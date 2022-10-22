package com.example.chillmax.presentation.details

import android.util.Log
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import com.example.chillmax.domain.models.*
import com.example.chillmax.domain.models.responses.*
import com.example.chillmax.domain.use_cases.UseCases
import com.example.chillmax.util.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class DetailsViewModel @Inject constructor(
    private val useCases: UseCases,
): ViewModel() {

    suspend fun getMoviesDetails(movieId: Int): Resource<MoviesDetails>{
        val result = useCases.getMoviesDetailsUseCase(movieId)
        Log.d("getMoviesDetails", result.data.toString())
        return result
    }

    suspend fun getTVDetails(tvId: Int): Resource<TVDetails>{
        val result = useCases.getTVDetailsUseCase(tvId)
        Log.d("getTVDetails", result.data.toString())
        return result
    }
    suspend fun getTVCredits(tvSeriesId:Int):Resource<TVCreditsApiResponse>{
        return useCases.getTVCreditsUseCase(tvSeriesId= tvSeriesId)
    }
    suspend fun getMovieCredits(movieId:Int):Resource<MovieCreditsApiResponses>{
        val result = useCases.getMovieCreditsUseCase(movieId = movieId)
        Log.d("DetailsViewModel", result.data.toString())
        return result
    }

}