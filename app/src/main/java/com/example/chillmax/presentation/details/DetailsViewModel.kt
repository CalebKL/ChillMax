package com.example.chillmax.presentation.details

import androidx.lifecycle.ViewModel
import com.example.chillmax.domain.models.MovieCredits
import com.example.chillmax.domain.models.TVCredits
import com.example.chillmax.domain.models.TVTopRated
import com.example.chillmax.domain.models.responses.*
import com.example.chillmax.domain.use_cases.UseCases
import com.example.chillmax.util.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class DetailsViewModel @Inject constructor(
    private val useCases: UseCases
): ViewModel() {

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

    suspend fun getTopRatedMoviesDetails(movieId:Int):Resource<TopRatedMoviesApiResponses>{
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