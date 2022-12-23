package com.example.chillmax.data.repository

import androidx.paging.PagingData
import com.example.chillmax.domain.models.*
import com.example.chillmax.domain.models.responses.CastDetailsApiResponse
import com.example.chillmax.domain.models.responses.GenresApiResponses
import com.example.chillmax.domain.repository.RemoteDataSource
import com.example.chillmax.util.Resource
import com.google.common.truth.Truth
import io.mockk.mockk
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.emptyFlow
import kotlinx.coroutines.runBlocking
import org.junit.Test

class RemoteSourceTest {
    companion object{
        fun mockRemoteSource(
            resource: Resource<MoviesDetails> = Resource.Loading(),
            resourceOne: Resource<TVDetails> = Resource.Loading(),
            resourceTwo: Resource<GenresApiResponses> = Resource.Loading(),
            resourceThree:  Resource<GenresApiResponses> = Resource.Loading(),
            resourceFour: Resource<CastDetailsApiResponse> = Resource.Loading(),
            flowOne: Flow<PagingData<PopularMovies>> = emptyFlow(),
            flowTwo: Flow<PagingData<TopRatedMovies>> = emptyFlow(),
            flowThree: Flow<PagingData<UpcomingMovies>> = emptyFlow(),
            flowFour: Flow<PagingData<TVAiringToday>> = emptyFlow(),
            flowFive: Flow<PagingData<TVTopRated>> = emptyFlow(),
            flowSix: Flow<PagingData<TVPopular>> = emptyFlow(),
            flowSeven: Flow<PagingData<MultiSearch>> = emptyFlow()
        ) = object : RemoteDataSource {
            override suspend fun getMovieDetails(filmId: Int) = resource

            override suspend fun getTVDetails(filmId: Int) = resourceOne

            override suspend fun getMovieGenres() = resourceTwo

            override suspend fun getTvShowsGenres() = resourceThree

            override fun getPopularMovies() = flowOne

            override fun getTopRatedMovies() = flowTwo

            override fun getUpcomingMovies() = flowThree

            override fun getTVAiringToday() = flowFour

            override fun getTVTopRated() = flowFive

            override fun getTVPopular() = flowSix

            override suspend fun getCastDetails(filmId: Int) = resourceFour

            override fun multiSearch(query: String) = flowSeven
        }
    }
    // Movie Details Test

    @Test
    fun `Get movieDetails starts with Loading, Returns Resource Loading`() = runBlocking {
        val repo = mockRemoteSource(
            resource = Resource.Loading()
        )
        val result = repo.getMovieDetails(2222)
        assert(result is Resource.Loading)
    }

    @Test
    fun `Get movieDetails Success, Return Resource Success + Data`() = runBlocking {
        val moviesDetails = mockk<MoviesDetails>()
        val repo = mockRemoteSource(
            resource = Resource.Success(moviesDetails)
        )
        val result = repo.getMovieDetails(2222)
        assert(result is Resource.Success)
    }

    @Test
    fun `Get Movie Details error, Returns Resource Error`() = runBlocking {
        val moviesDetails = mockk<MoviesDetails>()
        val repo = mockRemoteSource(
            resource = Resource.Error("Error Getting Movie details", moviesDetails)
        )
        val result = repo.getMovieDetails(2222)
        assert(result is Resource.Error && result.message == "Error Getting Movie details")
    }

    // TV Details Test

    @Test
    fun `Get tvDetails starts with Loading, Returns Resource Loading`() = runBlocking {
        val repo = mockRemoteSource(
            resourceOne = Resource.Loading()
        )
        val result = repo.getTVDetails(2222)
        assert(result is Resource.Loading)
    }

    @Test
    fun `Get tvDetails Success, Return Resource Success + Data`() = runBlocking {
        val tvDetails = mockk<TVDetails>()
        val repo = mockRemoteSource(
            resourceOne = Resource.Success(tvDetails)
        )
        val result = repo.getTVDetails(2222)
        assert(result is Resource.Success)
    }

    @Test
    fun `Get TV Details error, Returns Resource Error`() = runBlocking {
        val tvDetails = mockk<TVDetails>()
        val repo = mockRemoteSource(
            resourceOne = Resource.Error("Error Getting Movie details", tvDetails)
        )
        val result = repo.getTVDetails(2222)
        assert(result is Resource.Error && result.message == "Error Getting Movie details")
    }

    // Tv and Movie Genre

    @Test
    fun `Get tv and movie genre starts with Loading, Returns Resource Loading`() = runBlocking {
        val repo = mockRemoteSource(
            resourceThree = Resource.Loading()
        )
        val result = repo.getMovieGenres()
        assert(result is Resource.Loading)
    }

    @Test
    fun `Get tv and movie genre Success, Return Resource Success + Data`() = runBlocking {
        val genre = mockk<GenresApiResponses>()
        val repo = mockRemoteSource(
            resourceThree = Resource.Success(genre)
        )
        val result = repo.getMovieGenres()
        assert(result is Resource.Success)
    }

    @Test
    fun `Get tv and movie genre error, Returns Resource Error`() = runBlocking {
        val genre = mockk<GenresApiResponses>()
        val repo = mockRemoteSource(
            resourceThree = Resource.Error("Error Getting Movie details",genre)
        )
        val result = repo.getMovieGenres()
        assert(result is Resource.Error && result.message == "Error Getting Movie details")
    }

    // Cast Details Test

    @Test
    fun `Get casts starts with Loading, Returns Resource Loading`() = runBlocking {
        val repo = mockRemoteSource(
            resourceFour = Resource.Loading()
        )
        val result = repo.getCastDetails(2323)
        assert(result is Resource.Loading)
    }

    @Test
    fun `Get cast Success, Return Resource Success + Data`() = runBlocking {
        val cast = mockk<CastDetailsApiResponse>()
        val repo = mockRemoteSource(
            resourceFour = Resource.Success(cast)
        )
        val result = repo.getMovieGenres()
        assert(result is Resource.Success)
    }

    @Test
    fun `Get cast error, Returns Resource Error`() = runBlocking {
        val cast = mockk<CastDetailsApiResponse>()
        val repo = mockRemoteSource(
            resourceFour = Resource.Error("Empty",cast)
        )
        val result = repo.getMovieGenres()
        assert(result is Resource.Error && result.message == "Empty")
    }

}