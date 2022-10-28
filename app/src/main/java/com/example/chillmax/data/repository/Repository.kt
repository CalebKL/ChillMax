package com.example.chillmax.data.repository

import androidx.paging.PagingData
import com.example.chillmax.domain.models.*
import com.example.chillmax.domain.models.responses.*
import com.example.chillmax.domain.repository.DataStoreOperations
import com.example.chillmax.domain.repository.LocalDataSource
import com.example.chillmax.domain.repository.RemoteDataSource
import com.example.chillmax.util.Resource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.StateFlow
import javax.inject.Inject

class Repository @Inject constructor(
    private val local: LocalDataSource,
    private val remote: RemoteDataSource,
    private val dataStoreOperations: DataStoreOperations
){
    suspend fun getMoviesDetails(filmId:Int):Resource<MoviesDetails>{
        return remote.getMovieDetails(filmId= filmId)
    }

    suspend fun getTVDetails(filmId:Int):Resource<TVDetails>{
        return remote.getTVDetails(filmId = filmId)
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
    suspend fun getCastDetails(filmId: Int): Resource<CastDetailsApiResponse>{
        return remote.getCastDetails(filmId = filmId)
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
    suspend fun addToMyList(myList: MyList){
        return local.addToMyList(myList = myList)
    }
    fun isHeroLiked(myList: Int): Flow<Boolean> {
        return local.isHeroLiked(listId = myList)
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