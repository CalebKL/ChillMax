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
    suspend fun getMoviesDetails(movieId:Int):Resource<MoviesDetails>{
        return remote.getMovieDetails(movieId= movieId)
    }

    suspend fun getTVDetails(tvId:Int):Resource<TVDetails>{
        return remote.getTVDetails(tvId = tvId)
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
    suspend fun getCastDetails(movieId: Int): Resource<CastDetailsApiResponse>{
        return remote.getCastDetails(movieId = movieId)
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