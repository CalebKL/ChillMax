package com.example.chillmax.presentation.homescreen.components

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
import androidx.compose.ui.unit.dp
import com.example.chillmax.R

@Composable
fun SearchBar(
    search:String,
    onSearchClicked:(String)->Unit,
    onCloseClick:()->Unit,
    onTextChanged:(String)->Unit
) {
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
                    onClick = { onCloseClick() })
                {
                    Icon(
                        imageVector = Icons.Default.Close,
                        contentDescription = stringResource(R.string.close_click)
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

