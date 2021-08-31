package com.health.jokesapp

interface MainRepo {

    suspend fun getJoke() : Joke?
}