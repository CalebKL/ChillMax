package com.example.chillmax.presentation.details

import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.runtime.*
import androidx.hilt.navigation.compose.hiltViewModel
import coil.annotation.ExperimentalCoilApi
import com.example.chillmax.domain.models.MoviesDetails
import com.example.chillmax.domain.models.responses.CastDetailsApiResponse
import com.example.chillmax.presentation.details.components.DetailsContent
import com.example.chillmax.util.Constants.IMAGE_BASE_URL
import com.example.chillmax.util.Resource
import com.ramcosta.composedestinations.annotation.Destination
import com.ramcosta.composedestinations.navigation.DestinationsNavigator


@Destination
@ExperimentalMaterialApi
@ExperimentalCoilApi
@Composable
fun MovieDetailsScreen(
    navigator:DestinationsNavigator,
    filmId:Int,
    viewModel: DetailsViewModel = hiltViewModel(),
) {
    val scrollState = rememberLazyListState()
    val movieDetails = produceState<Resource<MoviesDetails>>(initialValue = Resource.Loading()) {
        value = viewModel.getMoviesDetails(filmId = filmId)
    }.value

    val casts = produceState<Resource<CastDetailsApiResponse>>(initialValue = Resource.Loading()) {
        value = viewModel.getCastDetails(filmId = filmId)
    }.value

    if (movieDetails is Resource.Success){
        DetailsContent(
            navigator = navigator,
            filmName =  movieDetails.data?.title.toString(),
            posterUrl = "${IMAGE_BASE_URL}/${movieDetails.data?.poster_path}",
            releaseDate = movieDetails.data?.release_date.toString(),
            overview = movieDetails.data?.overview.toString(),
            casts = casts,
            state = scrollState,
            mediaType = "movie",
            myList = movieDetails.data?.id!!
        )
    } else{
        CircularProgressIndicator()
    }

}
