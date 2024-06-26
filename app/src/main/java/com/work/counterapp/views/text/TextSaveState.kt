package com.work.counterapp.views.text


import android.os.Build
import android.os.Parcel
import android.os.Parcelable
import android.view.View


class TextSaveState : View.BaseSavedState {

    private lateinit var state: TextUiState

    constructor(superState: Parcelable) : super(superState)

    private constructor(parcelIn: Parcel) : super(parcelIn) {
        state = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
            parcelIn.readSerializable(
                TextUiState::class.java.classLoader,
                TextUiState::class.java
            ) as TextUiState
        } else {
            parcelIn.readSerializable() as TextUiState
        }
    }

    override fun writeToParcel(out: Parcel, flags: Int) {
        super.writeToParcel(out, flags)
        out.writeSerializable(state)
    }

    fun restore(): TextUiState = state

    fun save(uiState: TextUiState) {
        state = uiState
    }

    override fun describeContents() = 0

    companion object CREATOR : Parcelable.Creator<TextSaveState> {
        override fun createFromParcel(parcel: Parcel): TextSaveState =
            TextSaveState(parcel)

        override fun newArray(size: Int): Array<TextSaveState?> =
            arrayOfNulls(size)
    }
}
