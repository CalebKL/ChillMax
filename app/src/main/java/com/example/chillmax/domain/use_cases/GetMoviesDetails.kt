package com.example.chillmax.domain.use_cases

import com.example.chillmax.data.repository.Repository
import com.example.chillmax.domain.models.MoviesDetails
import com.example.chillmax.util.Resource

class GetMoviesDetails(
    val repository: Repository
) {
    suspend operator fun invoke(movieId: Int): Resource<MoviesDetails>{
        return repository.getMoviesDetails(movieId)
    }
}