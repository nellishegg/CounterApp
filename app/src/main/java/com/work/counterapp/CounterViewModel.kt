package com.work.counterapp

import androidx.lifecycle.ViewModel
import com.work.counterapp.views.increment.IncrementButtonUiState
import com.work.counterapp.views.reset.ResetButtonUiState
import com.work.counterapp.views.text.TextUiState

class CounterViewModel(
    private val repository: Repository
) : ViewModel() {

    fun init(): UiState {
        return UiState.Initial(
            text = TextUiState.Initial,
            incrementButton = IncrementButtonUiState.Initial,
            resetButton = ResetButtonUiState.Initial
        )
    }

    fun increment(): UiState {
        val num = repository.increment()
        return if (repository.isMax()) {
            UiState.Reset(
                text = TextUiState.Reset,
                incrementButton = IncrementButtonUiState.Reset,
                resetButton = ResetButtonUiState.Reset
            )
        } else
            UiState.Increment(
                text = TextUiState.Increment(num),
                incrementButton = IncrementButtonUiState.Increment,
                resetButton = ResetButtonUiState.Increment
            )
    }

    fun reset(): UiState {
        repository.reset()
        return UiState.Initial(
            text = TextUiState.Initial,
            incrementButton = IncrementButtonUiState.Initial,
            resetButton = ResetButtonUiState.Initial
        )
    }
}

