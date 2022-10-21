package com.example.chillmax.presentation.homescreen.components

import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.chillmax.presentation.homescreen.HomeViewModel

@Composable
fun FilmCategory(
    items: List<String>,
    modifier: Modifier,
    viewModel: HomeViewModel
) {
    Row(
        modifier = modifier,
        horizontalArrangement = Arrangement.Center
    ){
        items.forEach { item->
            val lineLength = animateFloatAsState(
                targetValue = if (item == viewModel.selectedOption.value) 2f else 0f,
                animationSpec = tween(
                    durationMillis = 300
                )
            )
            Text(
                text = item,
                color = if (item == viewModel.selectedOption.value) Color.White else Color.DarkGray,
                fontSize = 24.sp,
                modifier = Modifier
                    .padding(8.dp)
                    .clip(
                        shape = if (item == viewModel.selectedOption.value) RoundedCornerShape(8.dp) else RoundedCornerShape(0.dp)
                    )
                    .clickable(
                        indication = null,
                        interactionSource = remember{ MutableInteractionSource()},

                    ){
                        viewModel.setSelectedOption(item)
                    }
            )
        }

    }
}