package com.example.chillmax.data.paging_source

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.paging.PagingSource
import com.example.chillmax.data.remote.ChillMaxApi
import com.example.chillmax.domain.models.PopularMovies
import com.example.chillmax.domain.models.responses.PopularMoviesApiResponses
import com.google.common.truth.Truth
import io.mockk.coEvery
import io.mockk.every
import io.mockk.mockk
import junit.framework.Assert.assertEquals
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.runTest
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.kotlin.any
import org.mockito.kotlin.given
import org.robolectric.RobolectricTestRunner
import org.robolectric.annotation.Config

@ExperimentalCoroutinesApi
@RunWith(RobolectricTestRunner::class)
@Config(manifest=Config.NONE)
class PopularMoviesSourceTest {

    private val service = mockk<ChillMaxApi>()
    private lateinit var popularMoviesSource: PopularMoviesSource
    private val popularResponse = mockk<PopularMoviesApiResponses>()

    @get:Rule
    val instantExecutorRule = InstantTaskExecutorRule()

    @Before
    fun innit(){
        coEvery { service.getPopularMovies() } returns popularResponse
    }
    @Test
    fun `Popular paging source load - failure - http error`() = runTest {
        val error = RuntimeException("404", Throwable())

        given(service.getPopularMovies()).willThrow(error)

        val expectedResult = PagingSource.LoadResult.Error<Int, PopularMovies>(error)

        Truth.assertThat(expectedResult).isEqualTo(popularMoviesSource.load(
            PagingSource.LoadParams.Refresh(
                key = 0,
                loadSize = 1,
                placeholdersEnabled = false
            )
        ))
    }
}