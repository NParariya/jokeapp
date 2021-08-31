package com.health.jokesapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.lifecycle.ViewModelProvider


class MainActivity : AppCompatActivity() {


    lateinit var viewModel: MainViewModel
    override fun onCreate(savedInstanceState: Bundle?) {


        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setUpViewModel()
        setUpView()
    }

    private fun setUpView() {


        val tvjoke = findViewById<TextView>(R.id.tv_joke)

        val tvpunch_line = findViewById<TextView>(R.id.tv_punch_line)

        val button = findViewById<Button>(R.id.button)

        button.setOnClickListener {
            viewModel.getJokeFromServer()
        }

        viewModel.joke.observe(this, { joke ->
            joke?.let {
                tvjoke.text = it.setup
                tvpunch_line.text = it.punchline
            }
        })
    }

    private fun setUpViewModel() {
        viewModel = ViewModelProvider(this, ViewModelFactory()).get(MainViewModel::class.java)
    }



}