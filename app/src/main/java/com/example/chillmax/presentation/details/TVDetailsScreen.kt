package com.example.chillmax.presentation.details

import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.runtime.Composable
import androidx.compose.runtime.produceState
import androidx.hilt.navigation.compose.hiltViewModel
import coil.annotation.ExperimentalCoilApi
import com.example.chillmax.domain.models.TVDetails
import com.example.chillmax.domain.models.responses.CastDetailsApiResponse
import com.example.chillmax.presentation.details.components.DetailsContent
import com.example.chillmax.util.Constants
import com.example.chillmax.util.Resource
import com.ramcosta.composedestinations.annotation.Destination
import com.ramcosta.composedestinations.navigation.DestinationsNavigator

@OptIn(ExperimentalMaterialApi::class, ExperimentalCoilApi::class)
@Destination
@Composable
fun TVDetailsScreen(
    navigator: DestinationsNavigator,
    viewModel: DetailsViewModel = hiltViewModel(),
    filmId:Int,
) {
    val scrollState = rememberLazyListState()

    val tvDetails = produceState<Resource<TVDetails>>(initialValue = Resource.Loading()) {
        value = viewModel.getTVDetails(filmId = filmId)
    }.value

    val casts = produceState<Resource<CastDetailsApiResponse>>(initialValue = Resource.Loading()) {
        value = viewModel.getCastDetails(filmId)
    }.value

    if (tvDetails is Resource.Success){
        DetailsContent(
            navigator = navigator,
            filmName =  tvDetails.data?.name.toString(),
            posterUrl = "${Constants.IMAGE_BASE_URL}/${tvDetails.data?.posterPath}",
            releaseDate = tvDetails.data?.firstAirDate.toString(),
            overview = tvDetails.data?.overview.toString(),
            casts = casts,
            state = scrollState
        )
    } else{
        CircularProgressIndicator()
    }
}