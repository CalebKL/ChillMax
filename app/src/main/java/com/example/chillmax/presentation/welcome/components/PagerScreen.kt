package com.example.chillmax.presentation.welcome.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
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
import com.example.chillmax.R
import com.example.chillmax.domain.models.OnBoarding
import com.example.chillmax.presentation.ui.theme.SMALL_PADDING

@Composable
fun PagerScreen(onBoarding: OnBoarding) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(SMALL_PADDING),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ){
        Image(
            modifier = Modifier.fillMaxSize(),
            painter = painterResource(id = onBoarding.image),
            contentDescription = stringResource(R.string.onboarding_image)
        )
        Text(
            text = onBoarding.title,
            fontWeight = FontWeight.Bold,
            style = MaterialTheme.typography.h3,
            color = Color.White
        )
        Text(
            modifier = Modifier.alpha(ContentAlpha.medium),
            text = onBoarding.text,
            style = MaterialTheme.typography.subtitle1,
            color = Color.White
        )
    }
}

