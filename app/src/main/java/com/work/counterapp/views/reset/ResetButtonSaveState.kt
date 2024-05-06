package com.work.counterapp.views.reset

import android.os.Build
import android.os.Parcel
import android.os.Parcelable
import android.view.View


class ResetButtonSaveState : View.BaseSavedState {

    private lateinit var state: ResetButtonUiState

    constructor(superState: Parcelable) : super(superState)

    private constructor(parcelIn: Parcel) : super(parcelIn) {
        state = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
            parcelIn.readSerializable(
                ResetButtonUiState::class.java.classLoader,
                ResetButtonUiState::class.java
            ) as ResetButtonUiState
        } else {
            parcelIn.readSerializable() as ResetButtonUiState
        }
    }

    override fun writeToParcel(out: Parcel, flags: Int) {
        super.writeToParcel(out, flags)
        out.writeSerializable(state)
    }

    fun restore(): ResetButtonUiState = state

    fun save(uiState: ResetButtonUiState) {
        state = uiState
    }

    override fun describeContents() = 0

    companion object CREATOR : Parcelable.Creator<ResetButtonSaveState> {
        override fun createFromParcel(parcel: Parcel): ResetButtonSaveState =
            ResetButtonSaveState(parcel)

        override fun newArray(size: Int): Array<ResetButtonSaveState?> =
            arrayOfNulls(size)
    }
}
