package com.example.chillmax.presentation.homescreen.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.paging.LoadState
import androidx.paging.compose.collectAsLazyPagingItems
import androidx.paging.compose.items
import coil.annotation.ExperimentalCoilApi
import coil.compose.rememberImagePainter
import com.example.chillmax.R
import com.example.chillmax.presentation.destinations.DetailsScreenDestination
import com.example.chillmax.presentation.homescreen.HomeViewModel
import com.example.chillmax.presentation.ui.theme.MEDIUM_PADDING
import com.example.chillmax.presentation.ui.theme.SMALL_PADDING
import com.example.chillmax.util.Constants.IMAGE_BASE_URL
import com.ramcosta.composedestinations.navigation.DestinationsNavigator
import retrofit2.HttpException
import java.io.IOException

@ExperimentalCoilApi
@Composable
@ExperimentalMaterialApi
fun ScreenContent(
    navigator: DestinationsNavigator,
    viewModel: HomeViewModel = hiltViewModel(),
) {
    val tvTopRated = viewModel.getTVTopRated.value.collectAsLazyPagingItems()
    val topRatedMovies = viewModel.topRatedMovies.value.collectAsLazyPagingItems()
    val tvPopular = viewModel.tvPopular.value.collectAsLazyPagingItems()
    val popularMovies = viewModel.popularMovies.value.collectAsLazyPagingItems()
    val tvAiringToday = viewModel.tvAiringToday.value.collectAsLazyPagingItems()
    val upcomingMovies = viewModel.upcomingMovies.value.collectAsLazyPagingItems()

    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        item {
            FilmCategory(
                items = listOf("Movies", "Tv Shows", "My List"),
                modifier = Modifier.fillMaxWidth(),
                viewModel = viewModel()
            )
            Spacer(modifier = Modifier.height(SMALL_PADDING))
        }
        item {
            Text(
                modifier = Modifier
                    .padding(start = SMALL_PADDING),
                text = stringResource(R.string.categories),
                color = Color.White,
                fontWeight = FontWeight.Medium,
                style = MaterialTheme.typography.subtitle1
            )
            Spacer(modifier = Modifier.height(SMALL_PADDING))
        }
        item {
            Genres(
                viewModel = viewModel()
            )
            Spacer(modifier = Modifier.height(MEDIUM_PADDING))
        }
        item {
            Text(
                text = stringResource(R.string.top_rated),
                color = Color.White,
                fontSize = 18.sp
            )
            Spacer(modifier = Modifier.height(MEDIUM_PADDING))
        }
        item {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(220.dp),
                contentAlignment = Alignment.Center
            ){
                LazyRow(
                    horizontalArrangement = Arrangement.spacedBy(8.dp)
                ){
                    if (viewModel.selectedOption.value =="Tv Shows"){
                        items(tvTopRated){ film->
                            HeroItem(
                                modifier = Modifier
                                    .height(200.dp)
                                    .width(200.dp)
                                    .clickable {
                                    },
                                imageUrl = "$IMAGE_BASE_URL/${film!!.poster_path}",
                            )
                        }
                    }else{
                        items(topRatedMovies){ film->
                            HeroItem(
                                modifier = Modifier
                                    .height(220.dp)
                                    .width(200.dp)
                                    .clickable {
                                        navigator.navigate(DetailsScreenDestination(film?.id!!))
                                    },
                                imageUrl = "$IMAGE_BASE_URL/${film!!.poster_path}",
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
            Spacer(modifier = Modifier.height(MEDIUM_PADDING))
        }
        item {
            Text(
                text = stringResource(R.string.popular),
                color = Color.White,
                fontSize = 18.sp
            )
            Spacer(modifier = Modifier.height(MEDIUM_PADDING))
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
                        items(tvPopular){ film->
                            HeroItem(
                                modifier = Modifier
                                    .height(200.dp)
                                    .width(200.dp)
                                    .clickable {

                                    },
                                imageUrl = "$IMAGE_BASE_URL/${film!!.poster_path}",
                            )
                        }
                    }else{
                        items(popularMovies){ film->
                            HeroItem(
                                modifier = Modifier
                                    .height(200.dp)
                                    .width(200.dp)
                                    .clickable {

                                    },
                                imageUrl = "$IMAGE_BASE_URL/${film!!.poster_path}",
                            )
                        }
                    }
                    if (popularMovies.loadState.append == LoadState.Loading){
                        item {
                            CircularProgressIndicator(
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .wrapContentWidth(Alignment.CenterHorizontally)
                            )
                        }
                    }
                }
                popularMovies.apply {
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
                            val error = popularMovies.loadState.refresh as LoadState.Error
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
            Spacer(modifier = Modifier.height(MEDIUM_PADDING))
        }
        item {
            Text(
                text = if (viewModel.selectedOption.value == "Tv Shows") {
                    stringResource(R.string.airing_today)
                }else{
                     stringResource(R.string.upcoming)
                     },
                color = Color.White,
                fontSize = 18.sp
            )
            Spacer(modifier = Modifier.height(MEDIUM_PADDING))
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
                        items(tvAiringToday){ film->
                            HeroItem(
                                modifier = Modifier
                                    .height(200.dp)
                                    .width(200.dp)
                                    .clickable {

                                    },
                                imageUrl = "$IMAGE_BASE_URL/${film!!.poster_path}",
                            )
                        }
                    }else{
                        items(upcomingMovies){ film->
                            HeroItem(
                                modifier = Modifier
                                    .height(200.dp)
                                    .width(200.dp)
                                    .clickable {

                                    },
                                imageUrl = "$IMAGE_BASE_URL/${film!!.poster_path}",
                            )
                        }
                    }
                    if (upcomingMovies.loadState.append == LoadState.Loading){
                        item {
                            CircularProgressIndicator(
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .wrapContentWidth(Alignment.CenterHorizontally)
                            )
                        }
                    }
                }
                upcomingMovies.apply {
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
                            val error = upcomingMovies.loadState.refresh as LoadState.Error
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
            Spacer(modifier = Modifier.height(MEDIUM_PADDING))
        }
    }
}


@ExperimentalCoilApi
@Composable
fun HeroItem(
    modifier: Modifier,
    imageUrl:String,
){
    Card(
        modifier = modifier
    ){
        Image(
            painter = rememberImagePainter(
                data = imageUrl,
                builder = {
                    placeholder(R.drawable.ic_placeholder)
                    crossfade(true)
                }
            ),
            contentScale = ContentScale.Crop,
            contentDescription = stringResource(R.string.image_banner)
        )
    }
}
