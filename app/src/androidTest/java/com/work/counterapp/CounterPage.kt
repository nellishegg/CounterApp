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
        textUi.checkInitialState()
        incrementButtonUi.checkInitialState()
        resetButtonUi.checkInitialState()
    }

    fun clickIncrementButton() {
        incrementButtonUi.click()
    }

    fun checkIncrementState(click:Int) {
        textUi.checkIncrementState(click)
        incrementButtonUi.checkIncrementState()
        resetButtonUi.checkIncrementState()
    }

    fun checkResetState() {
        textUi.checkResetState()
        incrementButtonUi.checkResetState()
        resetButtonUi.checkResetState()
    }

    fun clickResetButton() {
        resetButtonUi.click()
    }

}
