package com.health.jokesapp

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch

class MainViewModel (private val repo: MainRepo) : ViewModel() {

    private var _joke : MutableLiveData<Joke?> = MutableLiveData()
    var joke : LiveData<Joke?> = _joke

    fun getJokeFromServer() {
        viewModelScope.launch {
            _joke.value = repo.getJoke()
        }
    }
}