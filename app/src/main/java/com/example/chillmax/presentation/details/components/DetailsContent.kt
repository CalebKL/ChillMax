package com.example.chillmax.presentation.details.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.chillmax.R
import com.example.chillmax.domain.models.MovieCredits
import com.example.chillmax.domain.models.responses.MovieCreditsApiResponses
import com.example.chillmax.presentation.ui.theme.EXTRA_SMALL_PADDING
import com.example.chillmax.presentation.ui.theme.SHEET_PADDING
import com.example.chillmax.presentation.ui.theme.SMALL_PADDING
import com.example.chillmax.util.Resource

@Composable
fun DetailsContent(
    navController:NavHostController
) {

}

@Composable
fun MovieBottomSheetContent(
    filmName:String,
    releaseDay: String,
    casts: List<MovieCreditsApiResponses>,
    overview: String,
    sheetColor: Color = MaterialTheme.colors.surface,
    contentColor: Color = Color.LightGray
){
    Column(
        modifier = Modifier
            .background(sheetColor)
            .padding(all = SHEET_PADDING)
    ){
      Row(
          modifier = Modifier
              .fillMaxWidth(),
          verticalAlignment = Alignment.CenterVertically
      ){
          Text(
              text = filmName,
              color = contentColor,
              fontWeight = FontWeight.Bold,
              fontSize = 14.sp
          )
      }
        Spacer(modifier = Modifier.height(SMALL_PADDING))
        Text(
            text = stringResource(R.string.release_date),
            color = contentColor,
            fontWeight = FontWeight.Bold,
            fontSize = 14.sp
        )
        Spacer(modifier = Modifier.height(EXTRA_SMALL_PADDING))
        Text(
            text = releaseDay,
            color = contentColor,
            fontWeight = FontWeight.Medium,
            fontSize = 10.sp
        )
        Spacer(modifier = Modifier.height(EXTRA_SMALL_PADDING))
        Text(
            text = overview,
            color = contentColor,
            fontWeight = FontWeight.Medium,
            fontSize = 10.sp
        )

    }
}

@Composable
fun BackgroundColorSpan() {

}

@Preview
@Composable
fun BottomSheetContentPreview() {
    MovieBottomSheetContent(
        filmName = "Vikings",
        releaseDay = "20th July 2019",
        overview = "kendenfkef rcrfnrfkrf",
        casts = emptyList()
    )
}