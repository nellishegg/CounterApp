package com.work.counterapp.views.increment


import android.os.Build
import android.os.Parcel
import android.os.Parcelable
import android.view.View


class IncrementButtonSaveState : View.BaseSavedState {

    private lateinit var state: IncrementButtonUiState

    constructor(superState: Parcelable) : super(superState)

    private constructor(parcelIn: Parcel) : super(parcelIn) {
        state = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
            parcelIn.readSerializable(
                IncrementButtonUiState::class.java.classLoader,
                IncrementButtonUiState::class.java
            ) as IncrementButtonUiState
        } else {
            parcelIn.readSerializable() as IncrementButtonUiState
        }
    }

    override fun writeToParcel(out: Parcel, flags: Int) {
        super.writeToParcel(out, flags)
        out.writeSerializable(state)
    }

    fun restore(): IncrementButtonUiState = state

    fun save(uiState: IncrementButtonUiState) {
        state = uiState
    }

    override fun describeContents() = 0

    companion object CREATOR : Parcelable.Creator<IncrementButtonSaveState> {
        override fun createFromParcel(parcel: Parcel): IncrementButtonSaveState =
            IncrementButtonSaveState(parcel)

        override fun newArray(size: Int): Array<IncrementButtonSaveState?> =
            arrayOfNulls(size)
    }
}