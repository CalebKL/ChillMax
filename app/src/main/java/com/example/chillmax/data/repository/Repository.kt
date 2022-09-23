package com.example.chillmax.data.repository

import androidx.paging.PagingData
import com.example.chillmax.domain.models.*
import com.example.chillmax.domain.models.responses.GenresApiResponses
import com.example.chillmax.domain.models.responses.MovieCreditsApiResponses
import com.example.chillmax.domain.models.responses.TVCreditsApiResponse
import com.example.chillmax.domain.repository.LocalDataSource
import com.example.chillmax.domain.repository.RemoteDataSource
import com.example.chillmax.util.Resource
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class Repository @Inject constructor(
    private val local: LocalDataSource,
    private val remote: RemoteDataSource
){
    suspend fun getMovieGenres(): Resource<GenresApiResponses> {
       return remote.getMovieGenres()
    }
    suspend fun getTvShowsGenres(): Resource<GenresApiResponses> {
        return remote.getTvShowsGenres()
    }
    fun getPopularMovies(): Flow<PagingData<PopularMovies>>{
        return remote.getPopularMovies()
    }
    fun getTopRatedMovies(): Flow<PagingData<TopRatedMovies>>{
        return remote.getTopRatedMovies()
    }
    fun getUpcomingMovies(): Flow<PagingData<UpcomingMovies>>{
        return remote.getUpcomingMovies()
    }
    fun getTVAiringToday(): Flow<PagingData<TVAiringToday>>{
        return remote.getTVAiringToday()
    }
    fun getTVTopRated(): Flow<PagingData<TVTopRated>>{
        return remote.getTVTopRated()
    }
    fun getTVPopular(): Flow<PagingData<TVPopular>>{
        return remote.getTVPopular()
    }
    suspend fun getTVCredits(): Resource<TVCreditsApiResponse>{
        return remote.getTVCredits()
    }
    suspend fun getMovieCredits(): Resource<MovieCreditsApiResponses>{
        return remote.getMovieCredits()
    }
    fun multiSearch(): Flow<PagingData<MultiSearch>>{
        return remote.multiSearch()
    }
    fun getMyList(): Flow<List<MyList>>{
        return local.getMyList()
    }
    fun getSelectedFromMyList(listId: Int):MyList{
        return local.getSelectedFromMyList(listId = listId)
    }
    fun addToMyList(myList: List<MyList>){
        return local.addToMyList(myList = myList)
    }
    suspend fun deleteOneFromMyList(myList: MyList){
        return local.deleteOneFromMyList(myList = myList)
    }
    suspend fun deleteAllContentFromMyList(){
        return local.deleteAllContentFromMyList()
    }
}