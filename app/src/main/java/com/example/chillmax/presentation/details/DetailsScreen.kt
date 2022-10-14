package com.example.chillmax.presentation.details

import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.runtime.*
import androidx.hilt.navigation.compose.hiltViewModel
import coil.annotation.ExperimentalCoilApi
import com.example.chillmax.domain.models.MoviesDetails
import com.example.chillmax.domain.models.TopRatedMoviesDetails
import com.example.chillmax.domain.models.responses.MovieCreditsApiResponses
import com.example.chillmax.presentation.details.components.DetailsContent
import com.example.chillmax.util.Constants.IMAGE_BASE_URL
import com.example.chillmax.util.Resource
import com.ramcosta.composedestinations.annotation.Destination
import com.ramcosta.composedestinations.navigation.DestinationsNavigator


@Destination
@ExperimentalMaterialApi
@ExperimentalCoilApi
@Composable
fun DetailsScreen(
    navigator:DestinationsNavigator,
    movieId:Int,
    viewModel: DetailsViewModel = hiltViewModel(),
) {
    val scrollState = rememberLazyListState()
    val details = produceState<Resource<MoviesDetails>>(initialValue = Resource.Loading()) {
        value = viewModel.getMoviesDetails(movieId)
    }.value

    val casts = produceState<Resource<MovieCreditsApiResponses>>(initialValue = Resource.Loading()) {
        value = viewModel.getMovieCredits(movieId)
    }.value

    if (details is Resource.Success){
        DetailsContent(
            navigator = navigator,
            filmName =  details.data?.title.toString(),
            posterUrl = "${IMAGE_BASE_URL}/${details.data?.poster_path}",
            releaseDate = details.data?.release_date.toString(),
            overview = details.data?.overview.toString(),
        )
    } else{
        CircularProgressIndicator()
    }
}
