package com.example.chillmax.presentation.homescreen.components

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.paging.LoadState
import com.example.chillmax.R

@Composable
fun EmptyScreen() {

}

@Composable
fun EmptyContent(
    icon: Int,
    message: String,
    error: LoadState.Error? = null
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState()),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ){
        Icon(
            painter = painterResource(id = icon),
            contentDescription = stringResource(R.string.error_icon),
        )
        Spacer(modifier = Modifier.height(10.dp))
        Text(
            text = message,
            color = Color.DarkGray,
            fontWeight = FontWeight.Medium,
            style = MaterialTheme.typography.subtitle1
        )
    }
}

@Preview
@Composable
fun EmptyContentPrev() {
    EmptyContent(icon = R.drawable.ic_network, message = "No Network Available")
}