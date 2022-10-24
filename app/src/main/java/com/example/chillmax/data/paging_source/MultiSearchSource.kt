package com.example.chillmax.data.paging_source

import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.example.chillmax.data.remote.ChillMaxApi
import retrofit2.HttpException
import java.io.IOException
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
            val nextPage = params.key ?: 1
            val multiSearch = chillMaxApi.multiSearch(nextPage, query = query)
            LoadResult.Page(
                data = multiSearch.searches,
                prevKey = if (nextPage == 1) null else nextPage - 1,
                nextKey = if (multiSearch.searches.isEmpty()) null else multiSearch.page + 1
            )

        }catch (e: IOException){
            LoadResult.Error(e)
        }catch (e: HttpException){
            LoadResult.Error(e)
        }
    }
}