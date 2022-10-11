package com.example.chillmax.data.paging_source

import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.example.chillmax.data.remote.ChillMaxApi
import com.example.chillmax.domain.models.TopRatedMovies
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

class TopRatedMoviesSource @Inject constructor(
    private val chillMaxApi: ChillMaxApi
): PagingSource<Int, TopRatedMovies>() {
    override fun getRefreshKey(state: PagingState<Int, TopRatedMovies>): Int? {
       return state.anchorPosition
    }

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, TopRatedMovies> {
        return try {
            val nextPage = params.key ?: 1
            val topRatedMovies = chillMaxApi.getTopRatedMovies(nextPage)
            LoadResult.Page(
                data = topRatedMovies.searches,
                prevKey = if (nextPage == 1) null else nextPage - 1,
                nextKey = if (topRatedMovies.searches.isEmpty()) null else topRatedMovies.page + 1
            )
        }catch (e: IOException){
            LoadResult.Error(e)
        }catch (e: HttpException){
            LoadResult.Error(e)
        }
    }
}