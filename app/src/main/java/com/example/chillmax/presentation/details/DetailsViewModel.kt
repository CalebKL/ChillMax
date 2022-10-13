package com.example.chillmax.presentation.details

import android.util.Log
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.chillmax.domain.models.*
import com.example.chillmax.domain.models.responses.*
import com.example.chillmax.domain.use_cases.UseCases
import com.example.chillmax.util.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import javax.inject.Inject
import com.example.chillmax.util.Constants.DETAILS_ID
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

@HiltViewModel
class DetailsViewModel @Inject constructor(
    private val useCases: UseCases,
    savedStateHandle: SavedStateHandle
): ViewModel() {

    private val _selectedHero: MutableStateFlow<TopRatedMoviesDetails?> = MutableStateFlow(null)
    val selectedHero: StateFlow<TopRatedMoviesDetails?> = _selectedHero

    init {
       viewModelScope.launch(Dispatchers.IO){
           val movieId = savedStateHandle.get<Int>(DETAILS_ID)
           _selectedHero.value = movieId?.let {
               useCases.getTopRatedMoviesDetailsUseCase(movieId = movieId)
           }
           _selectedHero.value?.id?.let { Log.d("Hero", it.toString()) }
       }
    }
    private suspend fun selectedTopRatedMovies(movieId: Int){
        useCases.getTopRatedMoviesDetailsUseCase(movieId =movieId)
    }

    suspend fun getTVTopRatedDetails(tvId:Int): Resource<TVTopRatedApiResponses>{
        return useCases.getTVTopRatedDetailsUseCase(tvId = tvId)
    }

    suspend fun getPopularMoviesDetails(movieId:Int): Resource<PopularMoviesApiResponses>{
        return useCases.getPopularMoviesDetailsUseCase(movieId = movieId)
    }

    suspend fun getUpcomingMoviesDetails(movieId:Int): Resource<UpcomingMoviesApiResponses>{
        return useCases.getUpcomingMoviesDetailsUseCase(movieId = movieId)
    }

    suspend fun getTVAiringTodayDetails(tvId:Int): Resource<TVAiringTodayApiResponses>{
        return useCases.getTVAiringDetailsUseCase(tvId = tvId)
    }

    suspend fun getTopRatedMoviesDetails(movieId:Int):TopRatedMoviesDetails{
        return useCases.getTopRatedMoviesDetailsUseCase(movieId = movieId)
    }

    suspend fun getTVPopularDetails(tvId:Int): Resource<TVPopularApiResponses>{
        return useCases.getTVPopularDetailsUseCase(tvId = tvId)
    }

    suspend fun getTVCredits(tvSeriesId:Int):Resource<TVCreditsApiResponse>{
        return useCases.getTVCreditsUseCase(tvSeriesId= tvSeriesId)
    }
    suspend fun getMovieCredits(movieId:Int):Resource<MovieCreditsApiResponses>{
        return useCases.getMovieCreditsUseCase(movieId = movieId)
    }
}