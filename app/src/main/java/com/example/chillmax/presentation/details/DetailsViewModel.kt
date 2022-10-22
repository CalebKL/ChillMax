package com.example.chillmax.presentation.details

import android.util.Log
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

    suspend fun getMoviesDetails(filmId: Int): Resource<MoviesDetails>{
        val result = useCases.getMoviesDetailsUseCase(filmId)
        Log.d("getMoviesDetails", result.data.toString())
        return result
    }

    suspend fun getTVDetails(filmId: Int): Resource<TVDetails>{
        val result = useCases.getTVDetailsUseCase(filmId)
        Log.d("getTVDetails", result.data.toString())
        return result
    }

    suspend fun getCastDetails(filmId:Int):Resource<CastDetailsApiResponse>{
        val result = useCases.castDetailsUseCase(filmId = filmId)
        Log.d("DetailsViewModel", result.data.toString())
        return result
    }

}