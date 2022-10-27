package com.example.chillmax.presentation.mylist

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.chillmax.domain.models.MyList
import com.example.chillmax.domain.use_cases.UseCases
import com.example.chillmax.util.Action
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MyListViewModel @Inject constructor(
    private val useCases: UseCases
):ViewModel(){

    val action: MutableState<Action> = mutableStateOf(Action.NO_ACTION)
    val listTitle: MutableState<String> = mutableStateOf("")
    val id: MutableState<Int> = mutableStateOf(0)
    val isLiked: MutableState<Boolean> = mutableStateOf(false)
    val imagePath: MutableState<String> = mutableStateOf("")
    val description: MutableState<String> = mutableStateOf("")
    val mediaType: MutableState<String> = mutableStateOf("")


    private suspend fun addToMyList(){
        val myList= MyList(
            isLiked = isLiked.value,
            id = id.value,
            imagePath = imagePath.value,
            title = listTitle.value,
            description = description.value,
            mediaType = mediaType.value
        )
       useCases.addToMyListUseCase(myList)
   }

    private suspend fun deleteOneFromList(){
        val myList = MyList(
            isLiked = isLiked.value,
            id = id.value,
            imagePath = imagePath.value,
            title = listTitle.value,
            description = description.value,
            mediaType = mediaType.value
        )
        useCases.deleteOneFromMyListUseCase(myList)
    }

    private suspend fun deleteAllContent(){
        useCases.deleteAllContentFromMyListUseCase()
    }

    fun isHeroLiked(){
        val myList = MyList(
            isLiked = isLiked.value,
            id = id.value,
            imagePath = imagePath.value,
            title = listTitle.value,
            description = description.value,
            mediaType = mediaType.value
        )
        viewModelScope.launch {
            useCases.isHeroLikedUseCase(myList = myList)
        }
    }

    suspend fun handleDatabaseActions(action: Action){
        when(action){
            Action.ADD ->{
                addToMyList()
            }
            Action.UNDO ->{
                addToMyList()
            }
            Action.DELETE ->{
                deleteOneFromList()
            }
            Action.DELETE_ALL ->{
                deleteAllContent()

            }else ->{

        }
        }
        this.action.value = Action.NO_ACTION
    }

}