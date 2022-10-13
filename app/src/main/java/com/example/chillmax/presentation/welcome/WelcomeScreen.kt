package com.example.chillmax.presentation.welcome

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import coil.annotation.ExperimentalCoilApi
import com.example.chillmax.domain.models.OnBoarding
import com.example.chillmax.presentation.destinations.HomeScreenDestination
import com.example.chillmax.presentation.destinations.SplashScreenDestination
import com.example.chillmax.presentation.welcome.components.PagerScreen
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.pager.HorizontalPager
import com.google.accompanist.pager.rememberPagerState
import com.ramcosta.composedestinations.annotation.Destination
import com.ramcosta.composedestinations.navigation.DestinationsNavigator

@Destination(start = true)
@Composable
@ExperimentalCoilApi
@ExperimentalPagerApi
fun WelcomeScreen(
    navigator: DestinationsNavigator,
    welcomeViewModel: WelcomeViewModel = hiltViewModel(),
)
{

    val pages = listOf(
        OnBoarding.First,
        OnBoarding.Second,
        OnBoarding.Third
    )
    val pagerState = rememberPagerState()
    Column(
        modifier = Modifier
            .fillMaxSize()
    ){
        HorizontalPager(
            modifier = Modifier.weight(10f),
            state = pagerState,
            count = 3,
            verticalAlignment = Alignment.Top
        ) {position ->
            PagerScreen(
                onBoarding = pages[position],
                onFinishClick = {
                    navigator.popBackStack()
                    navigator.navigate(HomeScreenDestination)
                    welcomeViewModel.saveOnBoardingState(completed = true)
                },
                pagerState = pagerState
            )

        }

    }

}

