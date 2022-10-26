package com.example.chillmax.presentation.search.components

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.Search
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.chillmax.R
import com.example.chillmax.presentation.search.SearchViewModel

@Composable
fun SearchBar(
    search:String,
    onSearchClicked:(String)->Unit,
    onCloseClick:()->Unit,
    onTextChanged:(String)->Unit
) {
    val viewModel= hiltViewModel<SearchViewModel>()
    var trailingIconState = viewModel.trailingIconState.value
    Surface(
        modifier = Modifier
            .height(56.dp)
            .fillMaxWidth(),
        elevation = AppBarDefaults.TopAppBarElevation
    ){
        TextField(
            modifier = Modifier.fillMaxWidth(),
            value = search,
            onValueChange = {
                onTextChanged(it)
            },
            placeholder = {
                Text(
                    modifier = Modifier.alpha(ContentAlpha.disabled),
                    text = stringResource(id = R.string.search),
                    color = Color.White
                )
            },
            singleLine = true,
            maxLines = 1,
            textStyle = MaterialTheme.typography.subtitle1,
            leadingIcon = {
                IconButton(
                    modifier = Modifier.alpha(ContentAlpha.disabled),
                    onClick = {}) {
                    Icon(
                        imageVector = Icons.Default.Search,
                        contentDescription = stringResource(id = R.string.search_icon)
                    )
                }
            },
            trailingIcon = {
                IconButton(
                    onClick = {
                        when(trailingIconState){
                            TrailingIconState.READY_TO_DELETE ->{
                                onTextChanged("")
                                trailingIconState=TrailingIconState.READY_TO_CLOSE
                            }
                            TrailingIconState.READY_TO_CLOSE ->{
                                if(search.isNotEmpty()){
                                    onTextChanged("")
                                }else {
                                    onCloseClick()
                                    trailingIconState =TrailingIconState.READY_TO_DELETE
                                }
                            }
                        }
                    }) {
                    Icon(
                        imageVector = Icons.Filled.Close,
                        contentDescription = stringResource(R.string.close_search_bar),
                        tint = Color.White
                    )
                }
            },
            keyboardOptions = KeyboardOptions(
                imeAction = ImeAction.Search
            ),
            keyboardActions = KeyboardActions {
                onSearchClicked(search)
            }
        )
    }
}

@Preview
@Composable
fun SearchBarPreview(){
    SearchBar(search = "", onSearchClicked = {}, onCloseClick = { /*TODO*/ }, onTextChanged = {})
}