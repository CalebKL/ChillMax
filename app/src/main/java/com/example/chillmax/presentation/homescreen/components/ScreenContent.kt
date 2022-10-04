package com.example.chillmax.presentation.homescreen.components

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.paging.LoadState
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
fun TVTopRatedPagingRequest(
    tvTopRated: LazyPagingItems<TVTopRated>
): Boolean {
    tvTopRated.apply {
        val error = when{
            loadState.append is LoadState.Error -> loadState.append as LoadState.Error
            loadState.prepend is LoadState.Error -> loadState.prepend as LoadState.Error
            loadState.refresh is LoadState.Error -> loadState.refresh as LoadState.Error
            else -> null
        }
        return when{
            loadState.refresh is LoadState.Loading ->{
                CircularProgressIndicator(
                    modifier = Modifier
                        .fillMaxWidth()
                        .wrapContentWidth(Alignment.CenterHorizontally)
                )
                false
            }
            error != null ->{
                EmptyScreen()
                false
            }
            tvTopRated.itemCount <1 ->{
                EmptyScreen()
                false
            }
            else ->{
                true
            }
        }
    }
}

@Composable
fun UpcomingMoviesPagingRequest(
    upcomingMovies: LazyPagingItems<UpcomingMovies>
): Boolean {
    upcomingMovies.apply {
        val error = when{
            loadState.append is LoadState.Error -> loadState.append as LoadState.Error
            loadState.prepend is LoadState.Error -> loadState.prepend as LoadState.Error
            loadState.refresh is LoadState.Error -> loadState.refresh as LoadState.Error
            else -> null
        }
        return when{
            loadState.refresh is LoadState.Loading ->{
                CircularProgressIndicator(
                    modifier = Modifier
                        .fillMaxWidth()
                        .wrapContentWidth(Alignment.CenterHorizontally)
                )
                false
            }
            error != null ->{
                EmptyScreen()
                false
            }
            upcomingMovies.itemCount <1 ->{
                EmptyScreen()
                false
            }
            else ->{
                true
            }
        }
    }
}


@Composable
fun HeroItem(
    modifier: Modifier,
    imageUrl: String
){

}