package com.example.chillmax.presentation.search.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.annotation.ExperimentalCoilApi
import coil.compose.rememberImagePainter
import com.example.chillmax.R
import com.example.chillmax.domain.models.MultiSearch
import com.example.chillmax.presentation.ui.theme.EXTRA_SMALL_PADDING
import com.example.chillmax.presentation.ui.theme.SMALL_PADDING
import com.example.chillmax.util.Constants
import com.example.chillmax.util.Constants.IMAGE_BASE_URL

@OptIn(ExperimentalCoilApi::class)
@Composable
fun SearchItem(
    searchItem: MultiSearch?,
    modifier: Modifier = Modifier,
    onClick:()->Unit
) {
    Card(
        modifier = modifier
            .clickable {
                onClick()
            },
        shape = RoundedCornerShape(SMALL_PADDING),
        elevation = EXTRA_SMALL_PADDING
    ){
        Row(
            modifier = Modifier.fillMaxWidth()
        ){
            Image(
                modifier= Modifier.weight(3f),
                painter = rememberImagePainter(
                    data = "${Constants.IMAGE_BASE_URL}/${searchItem?.posterPath}",
                    builder = {
                        placeholder(R.drawable.ic_placeholder)
                        crossfade(true)
                    }
                ),
                contentScale = ContentScale.Crop,
                contentDescription = stringResource(R.string.image_banner)
            )
            Column(
                modifier = modifier
                    .weight(7f)
                    .padding(SMALL_PADDING)
            ){
                Text(
                    style = MaterialTheme.typography.h6,
                    fontWeight = FontWeight.Bold,
                    text =(searchItem?.name?:searchItem?.originalName?: searchItem?.originalTitle?:"No Title Provided")
                )
                Spacer(modifier = Modifier.height(SMALL_PADDING))
                Text(
                    style = MaterialTheme.typography.subtitle2,
                    text = searchItem?.overview?:"No description",
                    maxLines = 5,
                    overflow = TextOverflow.Ellipsis
                )
            }
        }
    }
}
