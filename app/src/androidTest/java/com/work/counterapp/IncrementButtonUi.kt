package com.work.counterapp

import android.view.View
import android.widget.Button
import androidx.test.espresso.Espresso
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers
import androidx.test.espresso.matcher.ViewMatchers.isEnabled
import androidx.test.espresso.matcher.ViewMatchers.withId
import org.hamcrest.Matcher
import org.hamcrest.Matchers
import org.hamcrest.Matchers.not

class IncrementButtonUi(rootIdMatcher: Matcher<View>, rootClassMatcher: Matcher<View>) {

    private val interaction = Espresso.onView(
        Matchers.allOf(
            withId(R.id.incrementButton),
            ViewMatchers.isAssignableFrom(Button::class.java),
            rootIdMatcher,
            rootClassMatcher
        )
    )

    fun checkInitialState() {
        interaction.check(matches(isEnabled()))
    }

    fun click() {
        interaction.perform(androidx.test.espresso.action.ViewActions.click())
    }
    fun checkIncrementState() {
        interaction.check(matches(isEnabled()))
    }
    fun checkResetState() {
        interaction.check(matches(not(isEnabled())))
    }
}
