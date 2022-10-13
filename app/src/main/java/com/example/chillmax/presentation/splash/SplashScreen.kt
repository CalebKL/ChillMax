package com.example.chillmax.presentation.splash

import androidx.compose.animation.core.animateDpAsState
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.runtime.*
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import coil.annotation.ExperimentalCoilApi
import com.example.chillmax.presentation.destinations.HomeScreenDestination
import com.example.chillmax.presentation.destinations.WelcomeScreenDestination
import com.example.chillmax.presentation.splash.components.Splash
import com.example.chillmax.util.Constants.SPLASH_SCREEN_DELAY
import com.google.accompanist.pager.ExperimentalPagerApi
import com.ramcosta.composedestinations.annotation.Destination
import com.ramcosta.composedestinations.navigation.DestinationsNavigator
import kotlinx.coroutines.delay


@Destination
@Composable
@ExperimentalCoilApi
@ExperimentalPagerApi
fun SplashScreen(
    navigator:DestinationsNavigator
) {
    val splashViewModel = hiltViewModel<SplashViewModel>()
    val onBoardingCompleted by splashViewModel.onBoardingCompleted.collectAsState()

    var startAnimation by remember { mutableStateOf(false) }
    val offSet by animateDpAsState(
        targetValue = if (startAnimation) 0.dp else 100.dp,
        animationSpec = tween(
            durationMillis = 1000
        )
    )
    val alphaState by animateFloatAsState(
        targetValue = if (startAnimation) 1f else 0f,
        animationSpec = tween(
            durationMillis = 1000
        )
    )
    LaunchedEffect(key1 = true){
        startAnimation = true
        delay(SPLASH_SCREEN_DELAY)
        navigator.popBackStack()
        if (onBoardingCompleted){
            navigator.navigate(HomeScreenDestination)
        }else{
            navigator.navigate(WelcomeScreenDestination)
        }
    }
    Splash(offset = offSet, alpha = alphaState)
}
