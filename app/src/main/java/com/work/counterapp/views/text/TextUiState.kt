package com.work.counterapp.views.text

import androidx.annotation.ColorRes
import com.work.counterapp.R
import java.io.Serializable

interface TextUiState : Serializable {

    fun update(myCustomViewAction: UpdateCustomTextView)

    abstract class Abstract(private val text: String, @ColorRes private val color: Int) :
        TextUiState {

        override fun update(myCustomViewAction: UpdateCustomTextView) {
            myCustomViewAction.updateUi(text, color)
        }
    }

    object Initial : Abstract("0", R.color.green)
    data class Increment(private val text: Int) : Abstract(text.toString(), R.color.black)
    object Reset : Abstract("10", R.color.red)
}
