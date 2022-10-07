package com.example.chillmax.data.paging_source

import androidx.paging.PagingSource
import androidx.paging.PagingState
import coil.network.HttpException
import com.example.chillmax.data.remote.ChillMaxApi
import com.example.chillmax.domain.models.TopRatedMovies
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
            val apiResponse = chillMaxApi.getTopRatedMovies()
            val topRatedMovies = apiResponse.topRatedMovies
            if (topRatedMovies.isNotEmpty()) {
                LoadResult.Page(
                    data = topRatedMovies,
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