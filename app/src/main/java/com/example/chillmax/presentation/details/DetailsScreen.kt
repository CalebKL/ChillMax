package com.example.chillmax.presentation.details

import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.runtime.*
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import coil.annotation.ExperimentalCoilApi
import com.example.chillmax.domain.models.TopRatedMovies
import com.example.chillmax.domain.models.TopRatedMoviesDetails
import com.example.chillmax.domain.models.responses.MovieCreditsApiResponses
import com.example.chillmax.domain.models.responses.TopRatedMoviesApiResponses
import com.example.chillmax.presentation.details.components.DetailsContent
import com.example.chillmax.util.Constants.IMAGE_BASE_URL
import com.example.chillmax.util.Resource
import com.ramcosta.composedestinations.annotation.Destination
import com.ramcosta.composedestinations.navigation.DestinationsNavigator
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.emptyFlow

@Destination
@ExperimentalMaterialApi
@ExperimentalCoilApi
@Composable
fun DetailsScreen(
    navigator: DestinationsNavigator,
    viewModel: DetailsViewModel = hiltViewModel(),
) {


}
