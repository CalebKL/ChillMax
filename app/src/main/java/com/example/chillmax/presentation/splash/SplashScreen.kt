package com.example.chillmax.presentation.splash

import androidx.compose.animation.core.animateDpAsState
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.runtime.*
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.example.chillmax.navigation.Screen
import com.example.chillmax.presentation.splash.components.Splash
import com.example.chillmax.util.Constants.SPLASH_SCREEN_DELAY
import kotlinx.coroutines.delay

@Composable
fun SplashScreen(
    navController: NavHostController
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
        navController.popBackStack()
        if (onBoardingCompleted){
            navController.navigate(Screen.HomeScreen.route)
        }else{
            navController.navigate(Screen.WelcomeScreen.route)
        }
    }
    Splash(offset = offSet, alpha = alphaState)
}
