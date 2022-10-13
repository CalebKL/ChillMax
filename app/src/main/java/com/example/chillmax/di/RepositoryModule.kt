package com.example.chillmax.di

import android.content.Context
import com.example.chillmax.data.repository.DataStoreOperationsImp
import com.example.chillmax.data.repository.Repository
import com.example.chillmax.domain.repository.DataStoreOperations
import com.example.chillmax.domain.use_cases.*
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RepositoryModule {

    @Provides
    @Singleton
    fun provideDataStoreOperations(
        @ApplicationContext context: Context): DataStoreOperations{
        return DataStoreOperationsImp(context = context)
    }

    @Provides
    @Singleton
    fun providesUseCases(repository: Repository): UseCases{
        return UseCases(
            addToMyListUseCase = AddToMyListUseCase(repository),
            deleteAllContentFromMyListUseCase = DeleteAllContentFromMyListUseCase(repository),
            deleteOneFromMyListUseCase = DeleteOneFromMyListUseCase(repository),
            getMovieCreditsUseCase = GetMovieCreditsUseCase(repository),
            getMovieGenresUseCase = GetMovieGenresUseCase(repository),
            getMyListUseCase = GetMyListUseCase(repository),
            getPopularMoviesUseCase = GetPopularMoviesUseCase(repository),
            getSelectedFromMyListUseCase = GetSelectedFromMyListUseCase(repository),
            getTopRatedMoviesUseCase = GetTopRatedMoviesUseCase(repository),
            getTVAiringTodayUseCase = GetTVAiringTodayUseCase(repository),
            getTVCreditsUseCase = GetTVCreditsUseCase(repository),
            getTVGenresUseCase = GetTVGenresUseCase(repository),
            getTVPopularUseCase = GetTVPopularUseCase(repository),
            getUpcomingMoviesUseCase = GetUpcomingMoviesUseCase(repository),
            multiSearchUseCase = MultiSearchUseCase(repository),
            getTvTopRatedUseCase = TVTopRatedUseCase(repository),
            readOnBoardingUseCase = ReadOnBoardingUseCase(repository),
            saveOnBoardingUseCase = SaveOnBoardingUseCase(repository),
            getPopularMoviesDetailsUseCase = GetPopularMoviesDetailsUseCase(repository),
            getTVAiringDetailsUseCase = GetTVAiringDetailsUseCase(repository),
            getUpcomingMoviesDetailsUseCase = GetUpcomingMoviesDetailsUseCase(repository),
            getTVPopularDetailsUseCase = GetTVPopularDetailsUseCase(repository),
            getTopRatedMoviesDetailsUseCase = GetTopRatedMoviesDetailsUseCase(repository),
            getTVTopRatedDetailsUseCase = GetTVTopRatedDetailsUseCase(repository),
        )
    }
}