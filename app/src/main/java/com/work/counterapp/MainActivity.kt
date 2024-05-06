package com.work.counterapp

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.work.counterapp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var uiState: UiState

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val counterViewModel = (application as App).viewModel

        binding.incrementButton.setOnClickListener {
            uiState = counterViewModel.increment()
            uiState.update(binding.numberTextView, binding.incrementButton, binding.resetButton)
        }

        binding.resetButton.setOnClickListener {
            uiState = counterViewModel.reset()
            uiState.update(binding.numberTextView, binding.incrementButton, binding.resetButton)
        }

        if (savedInstanceState == null) {
            uiState = counterViewModel.init()
            uiState.update(binding.numberTextView, binding.incrementButton, binding.resetButton)
        }
    }
}