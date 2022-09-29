package com.example.chillmax.presentation.homescreen.components

import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun MovieShowRow() {
    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.Center
    ){
        Text(
            text = "Movie",
            style = MaterialTheme.typography.h3,
            fontWeight = FontWeight.Bold,
            color = Color.White
        )
        Spacer(modifier = Modifier.width(4.dp))
        Text(
            text = "TvShow",
            style = MaterialTheme.typography.h3,
            fontWeight = FontWeight.Normal,
            color = Color.White
        )
    }
}

@Preview
@Composable
fun MovieShowRowPreview() {
    MovieShowRow()
}