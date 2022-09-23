package com.example.chillmax.data.paging_source

import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.example.chillmax.data.remote.ChillMaxApi
import com.example.chillmax.domain.models.TVTopRated
import javax.inject.Inject

class TVTopRatedSource @Inject constructor(
    private val chillMaxApi: ChillMaxApi
): PagingSource<Int, TVTopRated>() {
    override fun getRefreshKey(state: PagingState<Int, TVTopRated>): Int? {
        return state.anchorPosition
    }

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, TVTopRated> {
        return try {
            val apiResponse = chillMaxApi.getTVTopRated()
            val tvTopRated = apiResponse.tvTopRated
            if (tvTopRated.isNotEmpty()) {
                LoadResult.Page(
                    data = tvTopRated,
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
        } catch (e: Exception) {
            LoadResult.Error(e)
        }
    }
}