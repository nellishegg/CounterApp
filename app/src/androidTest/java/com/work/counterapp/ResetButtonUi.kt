package com.work.counterapp

import android.view.View
import android.widget.Button
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.isAssignableFrom
import androidx.test.espresso.matcher.ViewMatchers.isDisplayed
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.espresso.matcher.ViewMatchers.withParent
import com.google.android.material.textfield.TextInputLayout
import org.hamcrest.Matcher
import org.hamcrest.Matchers.allOf
import org.hamcrest.Matchers.not

class ResetButtonUi(rootIdMatcher: Matcher<View>, rootClassMatcher: Matcher<View>) {

   private val interaction = onView(
        allOf(
            withId(R.id.resetButton),
            isAssignableFrom(Button::class.java),
            rootIdMatcher,
            rootClassMatcher
        )
    )

    fun checkInitialState() {
       interaction.check(matches(not(isDisplayed())))
    }

    fun click() {
        interaction.perform(androidx.test.espresso.action.ViewActions.click())
    }

    fun checkIncrementState() {
        interaction.check(matches(not(isDisplayed())))

    }

    fun checkResetState() {
        interaction.check(matches(isDisplayed()))

    }
}
