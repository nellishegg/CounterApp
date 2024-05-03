package com.work.counterapp

import android.view.View
import androidx.test.espresso.Espresso
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers
import androidx.test.espresso.matcher.ViewMatchers.isDisplayed
import androidx.test.espresso.matcher.ViewMatchers.withId
import com.google.android.material.textfield.TextInputLayout
import org.hamcrest.Matcher
import org.hamcrest.Matchers
import org.hamcrest.Matchers.not

class IncrementButtonUi(rootIdMatcher: Matcher<View>, rootClassMatcher: Matcher<View>) {

    val interaction = Espresso.onView(
        Matchers.allOf(
            withId(R.id.incrementButton),
            ViewMatchers.isAssignableFrom(TextInputLayout::class.java),
            ViewMatchers.withParent(withId(R.id.customIncrementButton)),
            rootIdMatcher,
            rootClassMatcher
        )
    )

    fun InitialState() {
        interaction.check(matches(isDisplayed()))
    }

    fun click() {
        interaction.perform(androidx.test.espresso.action.ViewActions.click())
    }
    fun IncrementState() {
        interaction.check(matches(isDisplayed()))
    }
    fun ResetState() {
        interaction.check(matches(not(isDisplayed())))
    }
}
