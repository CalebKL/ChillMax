package com.example.chillmax.presentation.search

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.PagingData
import androidx.paging.cachedIn
import androidx.paging.filter
import com.example.chillmax.domain.models.MultiSearch
import com.example.chillmax.domain.use_cases.UseCases
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SearchViewModel @Inject constructor(
    private val useCases: UseCases
):ViewModel(){
    private val _multiSearch = mutableStateOf<Flow<PagingData<MultiSearch>>>(emptyFlow())
    val multiSearch = _multiSearch

    private val _searchQuery = mutableStateOf("")
    val searchQuery = _searchQuery

    fun updateSearchQuery(query:String){
        _searchQuery.value = query
    }

    fun multiSearch(query: String){
        viewModelScope.launch(Dispatchers.IO){
            _multiSearch.value = useCases.multiSearchUseCase(query = query).map { pagingData->
                pagingData.filter {
                    ((it.title != null || it.originalTitle != null) &&
                            it.mediaType == "Tv Show" || it.mediaType == "Movie")
                }
            }.cachedIn(viewModelScope)
        }
    }
}