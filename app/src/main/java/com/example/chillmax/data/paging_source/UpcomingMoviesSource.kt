package com.example.chillmax.data.paging_source

import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.example.chillmax.data.remote.ChillMaxApi
import com.example.chillmax.domain.models.UpcomingMovies
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

class UpcomingMoviesSource @Inject constructor(
    private val chillMaxApi: ChillMaxApi
): PagingSource<Int, UpcomingMovies>() {
    override fun getRefreshKey(state: PagingState<Int, UpcomingMovies>): Int? {
        return state.anchorPosition
    }

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, UpcomingMovies> {
        return try {
            val nextPage = params.key ?: 1
            val upcomingMovies = chillMaxApi.getUpcomingMovies(nextPage)
            LoadResult.Page(
                data = upcomingMovies.searches,
                prevKey = if (nextPage == 1) null else nextPage - 1,
                nextKey = if (upcomingMovies.searches.isEmpty()) null else upcomingMovies.page + 1
            )
        }catch (e: IOException){
            return LoadResult.Error(e)
        }catch (e: HttpException){
            return LoadResult.Error(e)
        }
    }
}