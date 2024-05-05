package com.work.counterapp.views.reset

import android.content.Context
import android.os.Parcelable
import android.util.AttributeSet
import android.view.View
import androidx.appcompat.widget.AppCompatButton

class CustomResetButton : AppCompatButton, UpdateCustomResetButton {

    private lateinit var uiState: ResetButton

    constructor(context: Context) : super(context)
    constructor(context: Context, attributeSet: AttributeSet) : super(context, attributeSet)
    constructor(context: Context, attributeSet: AttributeSet, defStyleAttrs: Int) : super(
        context,
        attributeSet,
        defStyleAttrs
    )

    override fun updateUiState(outer: ResetButton) {
        uiState = outer
        uiState.update(this)
    }

    override fun updateUi(visibility: Boolean) {
        this.visibility = if (visibility) View.VISIBLE else View.GONE
    }

    override fun onSaveInstanceState(): Parcelable? {
        return super.onSaveInstanceState()?.let {
            val state = ResetButtonSaveState(it)
            state.save(uiState)
            return state
        }
    }

    override fun onRestoreInstanceState(state: Parcelable?) {
        val restoredState = state as ResetButtonSaveState
        super.onRestoreInstanceState(restoredState.superState)
        updateUiState(restoredState.restore())
    }
}

interface UpdateCustomResetButton {
    fun updateUiState(outer: ResetButton)
    fun updateUi(visibility: Boolean)
}