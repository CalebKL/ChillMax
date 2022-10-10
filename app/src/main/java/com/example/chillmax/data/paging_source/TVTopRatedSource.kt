package com.example.chillmax.data.paging_source

import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.example.chillmax.data.remote.ChillMaxApi
import com.example.chillmax.domain.models.TVTopRated
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

class TVTopRatedSource @Inject constructor(
    private val chillMaxApi: ChillMaxApi
): PagingSource<Int, TVTopRated>() {
    override fun getRefreshKey(state: PagingState<Int, TVTopRated>): Int? {
        return state.anchorPosition
    }

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, TVTopRated> {
        return try {
            val nextPage = params.key ?: 1
            val tvTopRated = chillMaxApi.getTVTopRated(nextPage)
            LoadResult.Page(
                data = tvTopRated.searches,
                prevKey = if (nextPage == 1) null else nextPage - 1,
                nextKey = if (tvTopRated.searches.isEmpty()) null else tvTopRated.page +1
            )
        }catch (e: IOException){
            LoadResult.Error(e)
        }catch (e: HttpException){
            LoadResult.Error(e)
        }
    }
}