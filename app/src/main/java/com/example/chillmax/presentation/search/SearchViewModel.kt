package com.example.chillmax.presentation.search

import android.util.Log
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.PagingData
import androidx.paging.cachedIn
import androidx.paging.filter
import com.example.chillmax.domain.models.MultiSearch
import com.example.chillmax.domain.models.TopRatedMovies
import com.example.chillmax.domain.use_cases.UseCases
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SearchViewModel @Inject constructor(
    private val useCases: UseCases
):ViewModel() {

    private val _searchResult = mutableStateOf<Flow<PagingData<MultiSearch>>>(emptyFlow())
    val searchResult = _searchResult

    private val _searchQuery = mutableStateOf("")
    val searchQuery = _searchQuery

    fun updateSearchQuery(query: String) {
        _searchQuery.value = query
    }

    fun searchAll(query: String) {
        viewModelScope.launch(Dispatchers.IO) {
            _searchResult.value = useCases.multiSearchUseCase(query = query).map { pagingData ->
                pagingData.filter {
                    ((it.title != null || it.originalName != null || it.originalTitle != null) &&
                            (it.mediaType == "tv" || it.mediaType == "movies"))
                }
            }.cachedIn(viewModelScope)
        }
    }

}