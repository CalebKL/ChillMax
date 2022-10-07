package com.example.chillmax.presentation.homescreen.components

import android.util.Log
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.paging.LoadState
import androidx.paging.compose.LazyPagingItems
import androidx.paging.compose.items
import com.example.chillmax.domain.models.*
import com.example.chillmax.presentation.homescreen.HomeViewModel
import com.example.chillmax.presentation.ui.theme.EXTRA_SMALL_PADDING
import com.example.chillmax.presentation.ui.theme.HERO_HEIGHT
import com.example.chillmax.presentation.ui.theme.SMALL_PADDING
import com.example.chillmax.util.Constants.BASE_URL
import com.example.chillmax.util.Constants.IMAGE_BASE_URL

@Composable
fun ScreenContent(
    navController: NavHostController,
    tvTopRated: LazyPagingItems<TVTopRated>,
    upcomingMovies: LazyPagingItems<UpcomingMovies>,
    tvPopular: LazyPagingItems<TVPopular>,
    tvAiringToday: LazyPagingItems<TVAiringToday>,
    topRatedMovies: LazyPagingItems<TopRatedMovies>,
    popularMovies: LazyPagingItems<PopularMovies>,
    viewModel: HomeViewModel = hiltViewModel(),
) {
    Log.d("ScreenContent", topRatedMovies.loadState.toString())
    Column(
        modifier = Modifier
            .fillMaxSize()
    ) {
        FilmCategory(
            items = listOf("Movies", "Tv Shows"),
            modifier = Modifier.fillMaxWidth(),
            viewModel = viewModel()
        )
        Spacer(modifier = Modifier.height(EXTRA_SMALL_PADDING))
        Text(
            modifier = Modifier
                .padding(start = SMALL_PADDING),
            text = "Genres",
            color = Color.White,
            fontWeight = FontWeight.Bold
        )
        Spacer(modifier = Modifier.height(EXTRA_SMALL_PADDING))
        Genres(
            viewModel = viewModel()
        )
        Text(
            text = "Trending today",
            color = Color.White,
            fontSize = 18.sp
        )
        Spacer(modifier = Modifier.height(SMALL_PADDING))
        Spacer(modifier = Modifier.height(EXTRA_SMALL_PADDING))
        TopRatedRow(
            tvTopRated = tvTopRated,
            topRatedMovies = topRatedMovies,
            viewModel = viewModel
        )
        Spacer(modifier = Modifier.height(SMALL_PADDING))

    }
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
fun TVPopularPagingRequest(
    tvPopular: LazyPagingItems<TVPopular>
): Boolean {
    tvPopular.apply {
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
                Text(text = "Not available")
                false
            }
            tvPopular.itemCount <1 ->{
                Text(text = "Not available")
                false
            }
            else ->{
                true
            }
        }
    }
}

@Composable
fun TVAiringTodayPagingRequest(
    tvAiringToday: LazyPagingItems<TVAiringToday>
): Boolean {
    tvAiringToday.apply {
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
            tvAiringToday.itemCount <1 ->{
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
fun TopRatedMoviesPagingRequest(
    topRatedMovies: LazyPagingItems<TopRatedMovies>
): Boolean {
    topRatedMovies.apply {
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
            topRatedMovies.itemCount <1 ->{
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
fun PopularMoviesPagingRequest(
    popularMovies: LazyPagingItems<PopularMovies>
): Boolean {
    popularMovies.apply {
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
                Text(text = "Not Available")
                false
            }
            popularMovies.itemCount <1 ->{
                Text(text = "Not Available")
                false
            }
            else ->{
                true
            }
        }
    }
}

@Composable
fun TopRatedRow(
    tvTopRated: LazyPagingItems<TVTopRated>,
    topRatedMovies: LazyPagingItems<TopRatedMovies>,
    viewModel: HomeViewModel
) {
    val tvTopRatedResult = TVTopRatedPagingRequest(tvTopRated = tvTopRated)
    val topRatedMoviesResult = TopRatedMoviesPagingRequest(topRatedMovies = topRatedMovies)
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(HERO_HEIGHT),
        contentAlignment = Alignment.Center
    ){
        LazyRow{
            if (topRatedMoviesResult) {
                if (viewModel.selectedOption.value == "Movies") {
                    items(topRatedMovies) { film->
                        HeroItem(
                            modifier = Modifier
                                .height(220.dp)
                                .width(250.dp)
                                .clickable {},
                            imageUrl = "$IMAGE_BASE_URL/${film?.poster_path}")
                    }
                } else if (tvTopRatedResult) {
                    items(tvTopRated) { film ->
                        HeroItem(
                            modifier = Modifier
                                .height(220.dp)
                                .width(250.dp)
                                .clickable {},
                            imageUrl = "$BASE_URL/${film?.poster_path}"
                        )
                    }
                }
            }
        }
    }
}

@Composable
fun PopularRow(
    popularMovies: LazyPagingItems<PopularMovies>,
    tvPopular: LazyPagingItems<TVPopular>,
    viewModel: HomeViewModel
) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(HERO_HEIGHT),
        contentAlignment = Alignment.Center
    ){
        LazyRow{
            items(popularMovies){ film->
                HeroItem(
                    modifier = Modifier
                        .height(220.dp)
                        .width(250.dp)
                        .clickable {},
                    imageUrl = "$BASE_URL/${film?.poster_path}"
                )
            }
        }
    }
}

@Composable
fun HeroItem(
    modifier: Modifier,
    imageUrl: String
){}