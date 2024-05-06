package com.work.counterapp

import com.work.counterapp.views.increment.IncrementButtonUiState
import com.work.counterapp.views.increment.UpdateCustomIncrementButton
import com.work.counterapp.views.reset.ResetButtonUiState
import com.work.counterapp.views.reset.UpdateCustomResetButton
import com.work.counterapp.views.text.TextUiState
import com.work.counterapp.views.text.UpdateCustomTextView

interface UiState {
    fun update(
        customTextView: UpdateCustomTextView,
        customIncrementButton: UpdateCustomIncrementButton,
        customResetButton: UpdateCustomResetButton
    )

    abstract class Abstract(
        private val text: TextUiState,
        private val incrementButton: IncrementButtonUiState,
        private val resetButton: ResetButtonUiState
    ) : UiState {
        override fun update(
            customTextView: UpdateCustomTextView,
            customIncrementButton: UpdateCustomIncrementButton,
            customResetButton: UpdateCustomResetButton
        ) {
            customTextView.updateUiState(text)
            customIncrementButton.updateUiState(incrementButton)
            customResetButton.updateUiState(resetButton)
        }
    }

    data class Initial(
        private val text: TextUiState,
        private val incrementButton: IncrementButtonUiState,
        private val resetButton: ResetButtonUiState
    ) : Abstract(text, incrementButton, resetButton)

    data class Increment(
        private val text: TextUiState,
        private val incrementButton: IncrementButtonUiState,
        private val resetButton: ResetButtonUiState
    ) : Abstract(text, incrementButton, resetButton)

    data class Reset(
        private val text: TextUiState,
        private val incrementButton: IncrementButtonUiState,
        private val resetButton: ResetButtonUiState
    ) : Abstract(text, incrementButton, resetButton)
}
