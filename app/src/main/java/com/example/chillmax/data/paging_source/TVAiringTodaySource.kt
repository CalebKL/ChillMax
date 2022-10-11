package com.example.chillmax.data.paging_source

import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.example.chillmax.data.remote.ChillMaxApi
import com.example.chillmax.domain.models.TVAiringToday
import retrofit2.HttpException
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
            val nextPage = params.key ?: 1
            val tvAiringToday = chillMaxApi.getTVAiringToday(nextPage)
            LoadResult.Page(
                data = tvAiringToday.searches,
                prevKey = if (nextPage == 1) null else nextPage - 1,
                nextKey = if (tvAiringToday.searches.isEmpty()) null else tvAiringToday.page + 1
            )
        }catch (e: IOException){
            LoadResult.Error(e)
        }catch (e: HttpException){
            LoadResult.Error(e)
        }
    }
}