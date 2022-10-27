package com.example.chillmax.presentation.mylist

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.chillmax.domain.models.MyList
import com.example.chillmax.domain.use_cases.UseCases
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MyListViewModel @Inject constructor(
    private val useCases: UseCases
):ViewModel(){

   suspend fun addToMyList(myList: MyList){
       useCases.addToMyListUseCase(myList)
   }

    suspend fun deleteOneFromList(myList: MyList){
        useCases.deleteOneFromMyListUseCase(myList)
    }

    suspend fun deleteAllContent(){
        useCases.deleteAllContentFromMyListUseCase()
    }

    fun isHeroLiked(myList: MyList){
        viewModelScope.launch {
            useCases.isHeroLikedUseCase(myList = myList)
        }
    }
}