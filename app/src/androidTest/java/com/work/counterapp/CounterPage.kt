package com.work.counterapp

import android.view.View
import android.widget.LinearLayout
import androidx.test.espresso.matcher.ViewMatchers.isAssignableFrom
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.espresso.matcher.ViewMatchers.withParent
import org.hamcrest.Matcher

class CounterPage {


    private val rootIdMatcher: Matcher<View> = withParent(withId(R.id.rootLayout))
    private val rootClassMatcher: Matcher<View> = withParent(isAssignableFrom(LinearLayout::class.java))

    private val textUi = TextUi( rootIdMatcher = rootIdMatcher, rootClassMatcher = rootClassMatcher)
    private val incrementButtonUi = IncrementButtonUi(rootIdMatcher = rootIdMatcher, rootClassMatcher = rootClassMatcher)
    private val resetButtonUi =  ResetButtonUi(rootIdMatcher = rootIdMatcher, rootClassMatcher = rootClassMatcher)

    fun checkInitialState() {
        textUi.InitialState()
        incrementButtonUi.InitialState()
        resetButtonUi.InitialState()
    }

    fun clickIncrementButton() {
        incrementButtonUi.click()
    }

    fun checkIncrementState() {
        textUi.IncrementState()
        incrementButtonUi.IncrementState()
        resetButtonUi.IncrementState()
    }

    fun checkResetState() {
        textUi.ResetState()
        incrementButtonUi.ResetState()
        resetButtonUi.ResetState()
    }

    fun clickResetButton() {
        resetButtonUi.click()
    }

}
