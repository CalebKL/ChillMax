package com.example.chillmax.data.paging_source

import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.example.chillmax.data.remote.ChillMaxApi
import com.example.chillmax.domain.models.PopularMovies
import retrofit2.HttpException
import retrofit2.http.Query
import java.io.IOException
import javax.inject.Inject

class PopularMoviesSource @Inject constructor(
    private val chillMaxApi: ChillMaxApi,
):PagingSource<Int, PopularMovies>() {

    override fun getRefreshKey(state: PagingState<Int, PopularMovies>): Int? {
        return state.anchorPosition
    }

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, PopularMovies> {
        return try {
            val nextPage = params.key ?: 1
            val popularMovies = chillMaxApi.getPopularMovies(nextPage)
            LoadResult.Page(
                data = popularMovies.searches,
                prevKey = if (nextPage == 1) null else nextPage - 1,
                nextKey = if (popularMovies.searches.isEmpty()) null else popularMovies.page +1
            )
        }catch (e:IOException){
            LoadResult.Error(e)
        }catch (e:HttpException){
            LoadResult.Error(e)
        }
    }
}