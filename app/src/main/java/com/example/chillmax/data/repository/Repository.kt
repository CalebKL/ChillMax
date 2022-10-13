package com.example.chillmax.data.repository

import androidx.paging.PagingData
import com.example.chillmax.domain.models.*
import com.example.chillmax.domain.models.responses.*
import com.example.chillmax.domain.repository.DataStoreOperations
import com.example.chillmax.domain.repository.LocalDataSource
import com.example.chillmax.domain.repository.RemoteDataSource
import com.example.chillmax.util.Resource
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class Repository @Inject constructor(
    private val local: LocalDataSource,
    private val remote: RemoteDataSource,
    private val dataStoreOperations: DataStoreOperations
){
    suspend fun getPopularMoviesDetails(movieId:Int): Resource<PopularMoviesApiResponses>{
        return remote.getPopularMoviesDetails(movieId = movieId)
    }
    suspend fun getTopRatedMoviesDetails(movieId:Int):TopRatedMoviesDetails{
        return remote.getTopRatedMoviesDetails(movieId= movieId)
    }
    suspend fun getUpcomingMoviesDetails(movieId:Int):Resource<UpcomingMoviesApiResponses>{
        return remote.getUpcomingMoviesDetails(movieId = movieId)
    }
    suspend fun getTVAiringTodayDetails(tvId:Int):Resource<TVAiringTodayApiResponses>{
        return remote.getTVAiringTodayDetails(tvId = tvId)
    }
    suspend fun getTVTopRatedDetails(tvId:Int):Resource<TVTopRatedApiResponses>{
        return remote.getTVTopRatedDetails(tvId = tvId)
    }
    suspend fun getTVPopularDetails(tvId:Int): Resource<TVPopularApiResponses>{
        return remote.getTVPopularDetails(tvId = tvId)
    }
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
    suspend fun getTVCredits(tvSeriesId: Int): Resource<TVCreditsApiResponse>{
        return remote.getTVCredits(tvSeriesId = tvSeriesId)
    }
    suspend fun getMovieCredits(movieId: Int): Resource<MovieCreditsApiResponses>{
        return remote.getMovieCredits(movieId = movieId)
    }
    fun multiSearch(query: String): Flow<PagingData<MultiSearch>>{
        return remote.multiSearch(query =query )
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
    suspend fun saveOnBoardingState(completed:Boolean){
        dataStoreOperations.saveOnBoardingState(completed = completed)
    }
    fun readOnBoardingState(): Flow<Boolean>{
       return dataStoreOperations.readOnBoardingState()
    }

}