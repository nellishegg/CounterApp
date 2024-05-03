package com.work.counterapp

import android.view.View
import android.widget.TextView
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.isAssignableFrom
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.espresso.matcher.ViewMatchers.withParent
import androidx.test.espresso.matcher.ViewMatchers.withText
import com.google.android.material.textfield.TextInputLayout
import org.hamcrest.Matcher
import org.hamcrest.Matchers.allOf


class TextUi(rootIdMatcher: Matcher<View>, rootClassMatcher: Matcher<View>) {

    private val interaction = onView(
        allOf(
            withId(R.id.numberTextView),
            isAssignableFrom(TextView::class.java),
            rootIdMatcher,
            rootClassMatcher
        )
    )


    fun checkInitialState() {
        interaction.check(matches(withText("0")))
            .check(matches(withTextColor(R.color.green)))
    }

    fun checkIncrementState(click: Int) {
        interaction.check(matches(withText(click.toString())))
            .check(matches(withTextColor(R.color.black)))
    }

    fun checkResetState() {
        interaction.check(matches(withText("10")))
            .check(matches(withTextColor(R.color.red)))
    }

}
