package com.example.chillmax.presentation.splash.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.DpOffset
import androidx.compose.ui.unit.dp
import androidx.core.view.ContentInfoCompat
import com.example.chillmax.R
import com.example.chillmax.presentation.ui.theme.IMAGE_SPLASH_PADDING
import com.example.chillmax.presentation.ui.theme.Purple500
import com.example.chillmax.presentation.ui.theme.SMALL_PADDING

@Composable
fun Splash(alpha: Float, offset: Dp){
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Black)
            .offset(y = offset)
            .alpha(alpha),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ){
        Image(
            modifier= Modifier.fillMaxSize(),
            painter = painterResource(id = R.drawable.download),
            contentDescription = stringResource(R.string.splash_screen_icon)
        )
    }
}

@Preview
@Composable
fun SplashPreview() {
    Splash(offset = 10.dp, alpha = 1f)
}