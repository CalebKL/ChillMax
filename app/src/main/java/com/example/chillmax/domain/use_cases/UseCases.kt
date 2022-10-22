package com.example.chillmax.domain.use_cases


class UseCases(
    val getTVDetailsUseCase: GetTVDetailsUseCase,
    val getMoviesDetailsUseCase: GetMoviesDetailsUseCase,
    val addToMyListUseCase: AddToMyListUseCase,
    val deleteAllContentFromMyListUseCase: DeleteAllContentFromMyListUseCase,
    val deleteOneFromMyListUseCase: DeleteOneFromMyListUseCase,
    val castDetailsUseCase: CastDetailsUseCase,
    val getMovieGenresUseCase: GetMovieGenresUseCase,
    val getMyListUseCase: GetMyListUseCase,
    val getPopularMoviesUseCase: GetPopularMoviesUseCase,
    val getSelectedFromMyListUseCase: GetSelectedFromMyListUseCase,
    val getTopRatedMoviesUseCase: GetTopRatedMoviesUseCase,
    val getTVAiringTodayUseCase: GetTVAiringTodayUseCase,
    val getTVGenresUseCase: GetTVGenresUseCase,
    val getTVPopularUseCase: GetTVPopularUseCase,
    val getUpcomingMoviesUseCase: GetUpcomingMoviesUseCase,
    val multiSearchUseCase: MultiSearchUseCase,
    val getTvTopRatedUseCase: TVTopRatedUseCase,
    val readOnBoardingUseCase: ReadOnBoardingUseCase,
    val saveOnBoardingUseCase: SaveOnBoardingUseCase
)