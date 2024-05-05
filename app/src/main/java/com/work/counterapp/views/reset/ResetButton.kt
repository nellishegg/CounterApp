package com.work.counterapp.views.reset

import java.io.Serializable

interface ResetButton : Serializable {

    fun update(customResetButton: UpdateCustomResetButton)

    abstract class Abstract(private val visibility: Boolean = false) : ResetButton {

        override fun update(customResetButton: UpdateCustomResetButton) {
            customResetButton.updateUi(visibility)
        }
    }
}

object Initial : ResetButton.Abstract()
object Increment : ResetButton.Abstract()
object Reset : ResetButton.Abstract(true)
