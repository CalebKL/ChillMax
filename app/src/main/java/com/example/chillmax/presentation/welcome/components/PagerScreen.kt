package com.example.chillmax.presentation.welcome.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.ContentAlpha
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.example.chillmax.R
import com.example.chillmax.domain.models.OnBoarding
import com.example.chillmax.presentation.ui.theme.Purple700
import com.example.chillmax.presentation.ui.theme.SMALL_PADDING
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.pager.HorizontalPagerIndicator
import com.google.accompanist.pager.rememberPagerState

@ExperimentalPagerApi
@Composable
fun PagerScreen(onBoarding: OnBoarding) {

    val pagerState = rememberPagerState()

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Black),
        contentAlignment = Alignment.BottomCenter
    )
    {
        Image(
            modifier = Modifier.fillMaxSize(),
            painter = painterResource(id = onBoarding.image),
            contentDescription = stringResource(R.string.onboarding_image)
        )
        Column(
            modifier = Modifier
                .fillMaxSize(),
            verticalArrangement = Arrangement.Bottom,
            horizontalAlignment = Alignment.CenterHorizontally
        ){

            Text(
                text = onBoarding.title,
                fontWeight = FontWeight.Bold,
                style = MaterialTheme.typography.h3,
                color = Color.White
            )
            Spacer(modifier = Modifier.padding(SMALL_PADDING))
            Text(
                modifier = Modifier.alpha(ContentAlpha.medium),
                text = onBoarding.text,
                style = MaterialTheme.typography.subtitle1,
                color = Color.White
            )
            Spacer(modifier = Modifier.padding(SMALL_PADDING))

            HorizontalPagerIndicator(
                modifier = Modifier
                    .align(Alignment.CenterHorizontally)
                    .padding(bottom = 20.dp),
                pagerState = pagerState,
                activeColor = Color.White,
                inactiveColor = Color.White,
                indicatorWidth = 12.dp,
                spacing = SMALL_PADDING)
        }
        }
}

