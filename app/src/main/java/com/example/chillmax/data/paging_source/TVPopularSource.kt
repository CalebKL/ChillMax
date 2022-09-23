package com.example.chillmax.data.paging_source

import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.example.chillmax.data.remote.ChillMaxApi
import com.example.chillmax.domain.models.TVPopular
import javax.inject.Inject

class TVPopularSource @Inject constructor(
    private val chillMaxApi: ChillMaxApi
): PagingSource<Int, TVPopular>() {
    override fun getRefreshKey(state: PagingState<Int, TVPopular>): Int? {
        return state.anchorPosition
    }

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, TVPopular> {
        return try {
            val apiResponse = chillMaxApi.getTVPopular()
            val tvPopular = apiResponse.tvPopular
            if (tvPopular.isNotEmpty()) {
                LoadResult.Page(
                    data = tvPopular,
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