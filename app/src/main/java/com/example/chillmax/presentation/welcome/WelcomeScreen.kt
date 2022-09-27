package com.example.chillmax.presentation.welcome

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion.CenterHorizontally
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import androidx.paging.ExperimentalPagingApi
import com.example.chillmax.R
import com.example.chillmax.domain.models.OnBoarding
import com.example.chillmax.presentation.ui.theme.Purple700
import com.example.chillmax.presentation.ui.theme.SMALL_PADDING
import com.example.chillmax.presentation.welcome.components.PagerScreen
import com.google.accompanist.pager.*

@Composable
@ExperimentalPagerApi
fun WelcomeScreen(navController: NavHostController)
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
            PagerScreen(onBoarding = pages[position])

        }

    }

}

