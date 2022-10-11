package com.example.chillmax.presentation.details

import androidx.lifecycle.ViewModel
import com.example.chillmax.domain.models.TVTopRated
import com.example.chillmax.domain.use_cases.UseCases
import com.example.chillmax.util.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class DetailsViewModel @Inject constructor(
    private val useCases: UseCases
): ViewModel() {
    suspend fun getTVTopRatedDetails(tvTopRatedId:Int): Resource<TVTopRated>{
        return useCases.getTvTopRatedUseCase()
    }
}