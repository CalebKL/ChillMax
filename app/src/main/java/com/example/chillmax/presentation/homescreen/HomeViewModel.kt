package com.example.chillmax.presentation.homescreen

import androidx.lifecycle.ViewModel
import com.example.chillmax.domain.use_cases.UseCases
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val useCases: UseCases
): ViewModel() {

}