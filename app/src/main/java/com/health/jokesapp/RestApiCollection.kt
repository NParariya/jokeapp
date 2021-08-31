package com.health.jokesapp

import retrofit2.http.GET

interface RestApiCollection {

    @GET("random_joke")
    suspend fun getJoke(): Joke
}