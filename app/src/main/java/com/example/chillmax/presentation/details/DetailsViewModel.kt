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

    suspend fun getTVTopRatedDetails(tvId:Int): Resource<TVTopRatedApiResponses>{
        val result = useCases.getTVTopRatedDetailsUseCase(tvId = tvId)
        Log.d("getMoviesDetails", result.data.toString())
        return result
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


    suspend fun getTVPopularDetails(tvId:Int): Resource<TVPopularApiResponses>{
        return useCases.getTVPopularDetailsUseCase(tvId = tvId)
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