package com.example.chillmax.presentation.homescreen.components

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.paging.LoadState
import androidx.paging.compose.LazyPagingItems
import com.example.chillmax.R
import com.example.chillmax.domain.models.*
import com.google.accompanist.swiperefresh.SwipeRefresh
import com.google.accompanist.swiperefresh.rememberSwipeRefreshState
import kotlinx.serialization.descriptors.PrimitiveKind

@Composable
fun EmptyScreen() {

}

@Composable
fun EmptyContent(
    icon: Int,
    message: String,
    error: LoadState.Error? = null,
    alphaAnim: Float,
    tvTopRated: LazyPagingItems<TVTopRated>? = null,
    upcomingMovies: LazyPagingItems<UpcomingMovies>? = null,
    tvPopular: LazyPagingItems<TVPopular>? = null,
    tvAiringToday: LazyPagingItems<TVAiringToday>? = null,
    topRatedMovies: LazyPagingItems<TopRatedMovies>? = null,
    popularMovies: LazyPagingItems<PopularMovies>? = null
) {

    var isRefreshing by remember { mutableStateOf(false) }

    SwipeRefresh(
        state = rememberSwipeRefreshState(isRefreshing = isRefreshing),
        swipeEnabled = error != null,
        onRefresh = {
            isRefreshing = true
            tvTopRated?.refresh()
            upcomingMovies?.refresh()
            tvPopular?.refresh()
            tvAiringToday?.refresh()
            topRatedMovies?.refresh()
            popularMovies?.refresh()
        }
    ) {

    }
    Column(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState()),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ){
        Icon(
            modifier = Modifier
                .size(120.dp)
                .alpha(alpha = alphaAnim),
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
    EmptyContent(icon = R.drawable.ic_network, message = "No Network", alphaAnim = 1f)
}