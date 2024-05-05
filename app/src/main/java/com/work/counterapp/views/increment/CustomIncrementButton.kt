package com.work.counterapp.views.increment

import android.content.Context
import android.os.Parcelable
import android.util.AttributeSet
import androidx.appcompat.widget.AppCompatButton

class CustomIncrementButton : AppCompatButton, UpdateCustomIncrementButton {

    private lateinit var uiState: IncrementButtonUiState

    constructor(context: Context) : super(context)
    constructor(context: Context, attributeSet: AttributeSet) : super(context, attributeSet)
    constructor(context: Context, attributeSet: AttributeSet, defStyleAttrs: Int) : super(
        context,
        attributeSet,
        defStyleAttrs
    )

    override fun updateUiState(outer: IncrementButtonUiState) {
        uiState = outer
        uiState.update(this)
    }

    override fun updateUi(enable: Boolean) {
        this.isEnabled = enable
    }

    override fun onSaveInstanceState(): Parcelable? {
        return super.onSaveInstanceState()?.let {
            val state = IncrementButtonSaveState(it)
            state.save(uiState)
            return state
        }
    }

    override fun onRestoreInstanceState(state: Parcelable?) {
        val restoredState = state as IncrementButtonSaveState
        super.onRestoreInstanceState(restoredState.superState)
        updateUiState(restoredState.restore())
    }
}

interface UpdateCustomIncrementButton {
    fun updateUiState(outer: IncrementButtonUiState)
    fun updateUi(enable: Boolean)
}