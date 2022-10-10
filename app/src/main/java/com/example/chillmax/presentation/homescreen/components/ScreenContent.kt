package com.example.chillmax.presentation.homescreen.components

import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.material.Card
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.paging.LoadState
import androidx.paging.compose.LazyPagingItems
import androidx.paging.compose.collectAsLazyPagingItems
import androidx.paging.compose.items
import coil.annotation.ExperimentalCoilApi
import coil.compose.rememberImagePainter
import com.example.chillmax.domain.models.*
import com.example.chillmax.presentation.homescreen.HomeViewModel
import com.example.chillmax.presentation.ui.theme.EXTRA_SMALL_PADDING
import com.example.chillmax.presentation.ui.theme.SMALL_PADDING
import com.example.chillmax.util.Constants.IMAGE_BASE_URL
import com.example.chillmax.R
import retrofit2.HttpException
import java.io.IOException

@ExperimentalCoilApi
@Composable
fun ScreenContent(
    navController: NavHostController,
    upcomingMovies: LazyPagingItems<UpcomingMovies>,
    tvPopular: LazyPagingItems<TVPopular>,
    tvAiringToday: LazyPagingItems<TVAiringToday>,
    popularMovies: LazyPagingItems<PopularMovies>,
    viewModel: HomeViewModel = hiltViewModel(),
) {
    val tvTopRated = viewModel.getTVTopRated.value.collectAsLazyPagingItems()
    val topRatedMovies = viewModel.topRatedMovies.value.collectAsLazyPagingItems()
    Log.d("ScreenContent", topRatedMovies.loadState.toString())

    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
    ) {
        item {
            FilmCategory(
                items = listOf("Movies", "Tv Shows"),
                modifier = Modifier.fillMaxWidth(),
                viewModel = viewModel()
            )
            Spacer(modifier = Modifier.height(EXTRA_SMALL_PADDING))
        }
        item {
            Text(
                modifier = Modifier
                    .padding(start = SMALL_PADDING),
                text = "Genres",
                color = Color.White,
                fontWeight = FontWeight.Bold
            )
            Spacer(modifier = Modifier.height(EXTRA_SMALL_PADDING))
        }
        item {
            Genres(
                viewModel = viewModel()
            )
        }
        item {
            Text(
                text = stringResource(R.string.top_rated),
                color = Color.White,
                fontSize = 18.sp
            )
            Spacer(modifier = Modifier.height(SMALL_PADDING))
        }
        item {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(220.dp),
                contentAlignment = Alignment.Center
            ){
                LazyRow{
                    if (viewModel.selectedOption.value =="Tv Shows"){
                        items(tvTopRated){ film->
                            HeroItem(
                                modifier = Modifier
                                    .height(220.dp)
                                    .width(130.dp)
                                    .clickable { },
                                imageUrl = "$IMAGE_BASE_URL/${film?.poster_path}"
                            )
                        }
                    }else{
                        items(topRatedMovies){ film->
                            HeroItem(
                                modifier = Modifier
                                    .height(220.dp)
                                    .width(130.dp)
                                    .clickable { },
                                imageUrl = "$IMAGE_BASE_URL/${film?.poster_path}"
                            )
                        }
                    }
                    if (topRatedMovies.loadState.append == LoadState.Loading){
                        item {
                            CircularProgressIndicator(
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .wrapContentWidth(Alignment.CenterHorizontally)
                            )
                        }
                    }
                }
                topRatedMovies.apply {
                    loadState
                    when(loadState.refresh){
                        is LoadState.Loading ->{
                            CircularProgressIndicator(
                                modifier = Modifier,
                                color = Color.Red,
                                strokeWidth = 2.dp
                            )
                        }
                        is LoadState.Error ->{
                            val error = topRatedMovies.loadState.refresh as LoadState.Error
                            Text(
                                text = when(error.error){
                                    is HttpException ->{
                                        "Oops! Something Went Wrong"
                                    }
                                    is IOException ->{
                                        "Couldn't Reach Server! Check Your Internet Connection"
                                    }
                                    else->{
                                        "Unknown Error"
                                    }
                                },
                                textAlign = TextAlign.Center,
                                color = Color.Red
                            )
                        }else->{}
                    }
                }
            }
        }
    }
}


@ExperimentalCoilApi
@Composable
fun HeroItem(
    modifier: Modifier,
    imageUrl:String
){
    Card(
        modifier = modifier
    ){
        Image(
            painter = rememberImagePainter(
                data = imageUrl,
                builder = {
                    placeholder(R.drawable.ic_place)
                    crossfade(true)
                }
            ),
            contentScale = ContentScale.Crop,
            contentDescription = "Image Banner"
        )
    }
}
