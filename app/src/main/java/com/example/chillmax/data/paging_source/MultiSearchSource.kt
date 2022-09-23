package com.example.chillmax.data.paging_source

import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.example.chillmax.data.remote.ChillMaxApi
import com.example.chillmax.domain.models.MultiSearch
import javax.inject.Inject

class MultiSearchSource @Inject constructor(
    private val chillMaxApi: ChillMaxApi,
    private val query: String
): PagingSource<Int, MultiSearch>() {
    override fun getRefreshKey(state: PagingState<Int, MultiSearch>): Int? {
        return state.anchorPosition
    }

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, MultiSearch> {
        return try {
            val apiResponse = chillMaxApi.multiSearch(query = query)
            val multiSearch = apiResponse.multiSearch
            if (multiSearch.isNotEmpty()){
                LoadResult.Page(
                    data = multiSearch,
                    prevKey = apiResponse.prevPage,
                    nextKey = apiResponse.nextPage
                )
                }else{
                    LoadResult.Page(
                        data = emptyList(),
                        prevKey = null,
                        nextKey = null
                    )
            }

        }catch (e:Exception){
            LoadResult.Error(e)
        }
    }
}