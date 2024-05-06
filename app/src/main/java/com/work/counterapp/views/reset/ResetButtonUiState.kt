package com.work.counterapp.views.reset

import java.io.Serializable

interface ResetButtonUiState : Serializable {

    fun update(customResetButton: UpdateCustomResetButton)

    abstract class Abstract(private val visibility: Boolean = false) : ResetButtonUiState {

        override fun update(customResetButton: UpdateCustomResetButton) {
            customResetButton.updateUi(visibility)
        }
    }

    object Initial : Abstract()
    object Increment : Abstract()
    object Reset : Abstract(true)
}

