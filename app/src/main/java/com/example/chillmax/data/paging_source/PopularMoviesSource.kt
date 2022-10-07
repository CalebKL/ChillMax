package com.example.chillmax.data.paging_source

import androidx.paging.PagingSource
import androidx.paging.PagingState
import coil.network.HttpException
import com.example.chillmax.data.remote.ChillMaxApi
import com.example.chillmax.domain.models.PopularMovies
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
           val apiResponse = chillMaxApi.getPopularMovies()
            val popularMovies = apiResponse.popularMovies
            if (popularMovies.isNotEmpty()){
                LoadResult.Page(
                    data = popularMovies,
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
        }catch (e:IOException){
            LoadResult.Error(e)
        }catch (e:HttpException){
            LoadResult.Error(e)
        }
    }
}