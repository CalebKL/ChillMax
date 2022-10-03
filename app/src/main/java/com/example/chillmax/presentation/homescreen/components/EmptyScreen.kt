package com.example.chillmax.presentation.homescreen.components

import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.ContentAlpha
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
import java.net.ConnectException
import java.net.SocketTimeoutException

@Composable
fun EmptyScreen(
    error: LoadState.Error? = null,
    tvTopRated: LazyPagingItems<TVTopRated>? = null,
    upcomingMovies: LazyPagingItems<UpcomingMovies>? = null,
    tvPopular: LazyPagingItems<TVPopular>? = null,
    tvAiringToday: LazyPagingItems<TVAiringToday>? = null,
    topRatedMovies: LazyPagingItems<TopRatedMovies>? = null,
    popularMovies: LazyPagingItems<PopularMovies>? = null
) {
    var message by remember { mutableStateOf("Find your Favourite Movies/Shows")}
    var icon by remember { mutableStateOf(R.drawable.ic_search)}

    if (error != null){
        message = parseErrorMessage(error)
        icon = R.drawable.ic_network
    }
    var startAnimation by remember { mutableStateOf(false) }

    val alphaAnim by animateFloatAsState(
        targetValue = if (startAnimation)ContentAlpha.disabled else 0f,
        animationSpec = tween(
            durationMillis = 1000
        )
    )

    LaunchedEffect(key1 = true){
        startAnimation = true
    }
    EmptyContent(
        icon = icon,
        message = message,
        alphaAnim = alphaAnim,
        error = error,
        tvTopRated = tvTopRated,
        tvPopular = tvPopular,
        upcomingMovies = upcomingMovies,
        tvAiringToday = tvAiringToday,
        topRatedMovies = topRatedMovies,
        popularMovies = popularMovies
    )
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

private fun parseErrorMessage(error: LoadState.Error): String{
    return when(error.error){
        is SocketTimeoutException ->{
            "Server Unavailable"
        }
        is ConnectException ->{
            "Internet Unavailable"
        }else ->{
            "Unknown Error"
        }
    }
}

@Preview
@Composable
fun EmptyContentPrev() {
    EmptyContent(icon = R.drawable.ic_network, message = "No Network", alphaAnim = 1f)
}
