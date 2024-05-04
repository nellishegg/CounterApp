package com.work.counterapp.views.text

import android.content.Context
import android.os.Parcelable
import android.util.AttributeSet
import androidx.annotation.ColorRes

class CustomTextView : androidx.appcompat.widget.AppCompatTextView, UpdateCustomTextView {

    private lateinit var uiState: TextUiState

    constructor(context: Context) : super(context)
    constructor(context: Context, attributeSet: AttributeSet) : super(context, attributeSet)
    constructor(context: Context, attributeSet: AttributeSet, defStyleAttrs: Int) : super(
        context,
        attributeSet,
        defStyleAttrs
    )

    override fun updateUiState(outer: TextUiState) {
        uiState = outer
        uiState.update(this)

    }

    override fun updateUi(text: String, color: Int) {
        setText(text)
        this.resources.getColor(color)
    }

    override fun onSaveInstanceState(): Parcelable? {
        return super.onSaveInstanceState()?.let {
            val state = TextSaveState(it)
            state.save(uiState)
            return state
        }
    }

    override fun onRestoreInstanceState(state: Parcelable?) {
        val restoredState = state as TextSaveState
        super.onRestoreInstanceState(restoredState.superState)
        updateUiState(restoredState.restore())
    }
}

interface UpdateCustomTextView {

    fun updateUiState(outer: TextUiState)
    fun updateUi(text: String, @ColorRes color: Int)

}