package com.work.counterapp.views.increment

import java.io.Serializable

interface IncrementButtonUiState : Serializable {

    fun update(customIncrementButton: UpdateCustomIncrementButton)

    abstract class Abstract(private val enable: Boolean = true) : IncrementButtonUiState {

        override fun update(customIncrementButton: UpdateCustomIncrementButton) {
            customIncrementButton.updateUi(enable)
        }
    }

    object Initial : Abstract()

    object Increment : Abstract()

    object Reset : Abstract(false)
}
