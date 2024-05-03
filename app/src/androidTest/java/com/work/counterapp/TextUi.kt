package com.work.counterapp

import android.view.View
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


class TextUi(rootIdMatcher: Matcher<View>, rootClassMatcher: Matcher<View>) {

    val interaction = onView(
        allOf(
            withId(R.id.textWithNumbers),
            isAssignableFrom(TextInputLayout::class.java),
            withParent(withId(R.id.customIncrementButton)),
            rootIdMatcher,
            rootClassMatcher
        )
    )

    fun InitialState() {
        interaction.check(matches(isDisplayed()))
//            .check(color)
    }

    fun IncrementState() {
        TODO("Not yet implemented")
    }

    fun ResetState() {
        TODO("Not yet implemented")
    }

}
