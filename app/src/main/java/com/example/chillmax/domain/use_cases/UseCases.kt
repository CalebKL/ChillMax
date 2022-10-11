package com.example.chillmax.domain.use_cases


class UseCases(
    val getTVPopularDetailsUseCase: GetTVPopularDetailsUseCase,
    val getTVTopRatedDetailsUseCase: GetTVTopRatedDetailsUseCase,
    val getTVAiringDetailsUseCase: GetTVAiringDetailsUseCase,
    val getUpcomingMoviesDetailsUseCase: GetUpcomingMoviesDetailsUseCase,
    val getTopRatedMoviesDetailsUseCase: GetUpcomingMoviesDetailsUseCase,
    val getPopularMoviesDetailsUseCase: GetUpcomingMoviesDetailsUseCase,
    val addToMyListUseCase: AddToMyListUseCase,
    val deleteAllContentFromMyListUseCase: DeleteAllContentFromMyListUseCase,
    val deleteOneFromMyListUseCase: DeleteOneFromMyListUseCase,
    val getMovieCreditsUseCase: GetMovieCreditsUseCase,
    val getMovieGenresUseCase: GetMovieGenresUseCase,
    val getMyListUseCase: GetMyListUseCase,
    val getPopularMoviesUseCase: GetPopularMoviesUseCase,
    val getSelectedFromMyListUseCase: GetSelectedFromMyListUseCase,
    val getTopRatedMoviesUseCase: GetTopRatedMoviesUseCase,
    val getTVAiringTodayUseCase: GetTVAiringTodayUseCase,
    val getTVCreditsUseCase: GetTVCreditsUseCase,
    val getTVGenresUseCase: GetTVGenresUseCase,
    val getTVPopularUseCase: GetTVPopularUseCase,
    val getUpcomingMoviesUseCase: GetUpcomingMoviesUseCase,
    val multiSearchUseCase: MultiSearchUseCase,
    val getTvTopRatedUseCase: TVTopRatedUseCase,
    val readOnBoardingUseCase: ReadOnBoardingUseCase,
    val saveOnBoardingUseCase: SaveOnBoardingUseCase
)