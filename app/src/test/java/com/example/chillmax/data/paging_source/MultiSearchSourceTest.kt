package com.example.chillmax.data.paging_source

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.paging.PagingSource
import com.example.chillmax.data.remote.ChillMaxApi
import com.example.chillmax.domain.models.MultiSearch
import com.example.chillmax.domain.models.responses.MultiSearchApiResponse
import com.google.common.truth.Truth
import junit.framework.Assert.assertEquals
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.runBlocking
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.MockitoAnnotations
import org.mockito.kotlin.any
import org.mockito.kotlin.given

@ExperimentalCoroutinesApi
class MultiSearchSourceTest {

    @get:Rule
    val instantExecutorRule = InstantTaskExecutorRule()

    @Mock lateinit var api:ChillMaxApi
    lateinit var multiSearchSource: MultiSearchSource

    companion object {
        val multiSearchResponse = MultiSearchApiResponse(
            page = 1,
            searches = listOf(
                MultiSearch(
                    adult = false,
                    backdropPath = "just sum text",
                    firstAirDate = "12/12/12",
                    genreIds = null,
                    id = 1,
                    mediaType = "Movie",
                    name ="",
                    originCountry = null,
                    originalLanguage = "English",
                    originalName = "vikings",
                    originalTitle = "Ragnar",
                    overview = "Just some text",
                    popularity = 34.5,
                    posterPath = null,
                    releaseDate = "12/12/12",
                    title = "Lothbrok",
                    video = false,
                    voteAverage = 34.5,
                    voteCount = 7
                )
            ),
            totalPages = 3,
            totalResults = 5
        )
    }

    @Before
    fun setup(){
        MockitoAnnotations.openMocks(this)
        multiSearchSource = MultiSearchSource(api, query = "new")

    }

    @Test
    fun `multi search paging source load - failure - http error`()= runBlocking{
        val error = RuntimeException("404", Throwable())
        given(api.multiSearch(any(), any(), any())).willThrow(error)
        val expectedResult = PagingSource.LoadResult.Error<Int, MultiSearch>(error)
        assertEquals(expectedResult, multiSearchSource.load(PagingSource.LoadParams.Refresh(
            key = 0,
            loadSize = 1,
            placeholdersEnabled = false
        )
        ).toString()
        )
    }

}