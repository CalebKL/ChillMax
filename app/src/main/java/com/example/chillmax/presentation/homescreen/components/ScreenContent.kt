package com.example.chillmax.presentation.homescreen.components

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.paging.compose.LazyPagingItems
import com.example.chillmax.domain.models.*

@Composable
fun ScreenContent(
    navController: NavHostController,
    tvTopRated: LazyPagingItems<TVTopRated>,
    upcomingMovies: LazyPagingItems<UpcomingMovies>,
    tvPopular: LazyPagingItems<TVPopular>,
    tvAiringToday: LazyPagingItems<TVAiringToday>,
    topRatedMovies: LazyPagingItems<TopRatedMovies>,
    popularMovies: LazyPagingItems<PopularMovies>,
) {

}

@Composable
fun HeroItem() {

}