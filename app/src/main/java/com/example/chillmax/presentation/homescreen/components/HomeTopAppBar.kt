package com.example.chillmax.presentation.homescreen.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.chillmax.R
import com.example.chillmax.presentation.ui.theme.LARGE_PADDING

@Composable
fun HomeTopAppBar(
    onSearchClick:()->Unit
) {
    Row(modifier = Modifier
            .fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Center
    ){
        Text(
            modifier = Modifier.weight(8f),
            text = stringResource(R.string.chillmax),
            style = MaterialTheme.typography.h4,
            fontWeight = FontWeight.Bold
        )
        IconButton(
            modifier= Modifier.weight(1f),
            onClick = onSearchClick
        ) {
            Icon(
                modifier = Modifier.size(LARGE_PADDING),
                imageVector = Icons.Default.Search,
                contentDescription = stringResource(R.string.search_icon),
            )
        }
    }
}

@Preview
@Composable
fun TopAppBarPreview() {
    HomeTopAppBar(onSearchClick = {})
}
