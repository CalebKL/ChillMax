package com.example.chillmax.presentation.welcome.components

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import com.example.chillmax.R
import com.example.chillmax.domain.models.OnBoarding
import com.example.chillmax.presentation.ui.theme.INDICATOR_WIDTH
import com.example.chillmax.presentation.ui.theme.LARGE_PADDING
import com.example.chillmax.presentation.ui.theme.Purple700
import com.example.chillmax.presentation.ui.theme.SMALL_PADDING
import com.example.chillmax.util.Constants.CURRENT_PAGE
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.pager.HorizontalPagerIndicator
import com.google.accompanist.pager.PagerState

@ExperimentalPagerApi
@Composable
fun PagerScreen(
    onBoarding: OnBoarding,
    onFinishClick:()->Unit,
    pagerState: PagerState
    ) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Black)
    )
    {
        Image(
            modifier = Modifier
                .fillMaxSize(),
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
                style = MaterialTheme.typography.h2,
                color = Color.White
            )
            Spacer(modifier = Modifier.padding(SMALL_PADDING))
            Text(
                modifier = Modifier
                    .alpha(ContentAlpha.medium),
                text = onBoarding.text,
                style = MaterialTheme.typography.subtitle1,
                color = Color.White
            )
            Spacer(modifier = Modifier.padding(SMALL_PADDING))

            HorizontalPagerIndicator(
                modifier = Modifier,
                pagerState = pagerState,
                activeColor = Purple700,
                inactiveColor = Color.White,
                indicatorWidth = INDICATOR_WIDTH,
                spacing = SMALL_PADDING)
            Spacer(modifier = Modifier.padding(SMALL_PADDING))
            FinishButton( onFinishClick = onFinishClick, pagerState = pagerState)
        }
        }
}

@ExperimentalPagerApi
@Composable
fun FinishButton(
    pagerState: PagerState,
    onFinishClick:() ->Unit
) {

    Box(
        modifier = Modifier.padding(LARGE_PADDING),
        contentAlignment = Alignment.BottomEnd
    ) {
        AnimatedVisibility(
            modifier = Modifier.fillMaxWidth(),
            visible = pagerState.currentPage == CURRENT_PAGE
        ) {
            Button(
                onClick = onFinishClick,
                colors = ButtonDefaults.buttonColors(
                    backgroundColor = Purple700,
                    contentColor = Color.White
                )
            )
            {
                Text(text = stringResource(R.string.finish_button))
            }
        }
    }
}

