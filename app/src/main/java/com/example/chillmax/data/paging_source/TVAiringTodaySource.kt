package com.example.chillmax.data.paging_source

import androidx.paging.PagingSource
import androidx.paging.PagingState
import coil.network.HttpException
import com.example.chillmax.data.remote.ChillMaxApi
import com.example.chillmax.domain.models.TVAiringToday
import java.io.IOException
import javax.inject.Inject

class TVAiringTodaySource @Inject constructor(
    private val chillMaxApi: ChillMaxApi
): PagingSource<Int, TVAiringToday>() {

    override fun getRefreshKey(state: PagingState<Int, TVAiringToday>): Int? {
       return state.anchorPosition
    }

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, TVAiringToday> {
        return try {
            val apiResponse = chillMaxApi.getTVAiringToday()
            val tvAiringToday = apiResponse.tvAiringToday
            if (tvAiringToday.isNotEmpty()) {
                LoadResult.Page(
                    data = tvAiringToday,
                    prevKey = apiResponse.prevPage,
                    nextKey = apiResponse.nextPage
                )
            } else {
                LoadResult.Page(
                    data = emptyList(),
                    prevKey = null,
                    nextKey = null
                )
            }
        }catch (e: IOException){
            LoadResult.Error(e)
        }catch (e: HttpException){
            LoadResult.Error(e)
        }
    }
}