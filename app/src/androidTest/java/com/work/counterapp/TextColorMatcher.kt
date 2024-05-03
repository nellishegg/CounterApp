package com.work.counterapp

import android.view.View
import android.widget.TextView
import androidx.core.content.ContextCompat
import androidx.test.espresso.matcher.BoundedMatcher
import org.hamcrest.Description
import org.hamcrest.Matcher


fun withTextColor(expectedId: Int): Matcher<View> {
    return object : BoundedMatcher<View, TextView>(TextView::class.java) {
        override fun matchesSafely(textView: TextView): Boolean {
            val colorId = ContextCompat.getColor(textView.context, expectedId)
            return textView.currentTextColor == colorId
        }

        override fun describeTo(description: Description) {
            description.appendText("with text color: ")
            description.appendValue(expectedId)
        }
    }
}
