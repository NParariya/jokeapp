package com.health.jokesapp

import android.util.Log

class MainRepoImpl (private val apiService: RestApiCollection) : MainRepo {
    override suspend fun getJoke(): Joke? {
        return try {
            apiService.getJoke()
        } catch (e: Exception) {
            Log.e("Error", e.stackTraceToString())
            null
        }
    }
}