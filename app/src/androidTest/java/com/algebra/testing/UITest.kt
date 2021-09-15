package com.algebra.testing

import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.*
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.rule.ActivityTestRule
import androidx.test.runner.AndroidJUnit4

import org.junit.Test
import org.junit.runner.RunWith
import org.junit.Rule

/**
 * Instrumented test, which will execute on an Android device.
 */
@RunWith(AndroidJUnit4::class)
class UITest {
    @get:Rule var activityTestRule = ActivityTestRule(MainActivity::class.java)

    @Test
    fun addNumbersCorrectlyAndDisplaysResult() {
        onView(withId(R.id.etFirstNumber))
            .perform(typeText("3"), closeSoftKeyboard() )

        onView(withId(R.id.etSecondNumber))
            .perform(typeText("3"), closeSoftKeyboard())

        onView(withId(R.id.bAdd)).perform(click())

        // Check that the text was changed.
        onView(withId(R.id.tvResult))
            .check(matches(withText("3 + 3 = 6")))

        thenEditTextsAreCleared()
    }

    @Test
    fun subtractsNumbersCorrectlyAndDisplaysResult() {
        onView(withId(R.id.etFirstNumber))
            .perform(typeText("6"), closeSoftKeyboard() )

        onView(withId(R.id.etSecondNumber))
            .perform(typeText("3"), closeSoftKeyboard() )

        onView(withId(R.id.bSubtract)).perform(click())

        // Check that the text was changed.
        onView(withId(R.id.tvResult))
            .check(matches(withText("6 - 3 = 3")))

        thenEditTextsAreCleared()
    }

    @Test
    fun multipliesNumbersCorrectlyAndDisplaysResult() {
        onView(withId(R.id.etFirstNumber))
            .perform(typeText("6"), closeSoftKeyboard() )

        onView(withId(R.id.etSecondNumber))
            .perform(typeText("3"), closeSoftKeyboard() )

        onView(withId(R.id.bMultiply)).perform(click())

        // Check that the text was changed.
        onView(withId(R.id.tvResult))
            .check(matches(withText("6 x 3 = 18")))

        thenEditTextsAreCleared()
    }

    @Test
    fun dividesNumbersCorrectlyAndDisplaysResult() {
        onView(withId(R.id.etFirstNumber))
            .perform(typeText("6"), closeSoftKeyboard() )

        onView(withId(R.id.etSecondNumber))
            .perform(typeText("3"), closeSoftKeyboard() )

        onView(withId(R.id.bDivide)).perform(click())

        // Check that the text was changed.
        onView(withId(R.id.tvResult))
            .check(matches(withText("6 / 3 = 2")))

        thenEditTextsAreCleared()
    }

    @Test
    fun setsErrorWhenFirstValueIsMissing() {
        onView(withId(R.id.etFirstNumber))
            .perform(typeText(""), closeSoftKeyboard() )

        onView(withId(R.id.etSecondNumber))
            .perform(typeText("3"), closeSoftKeyboard() )

        onView(withId(R.id.bSubtract)).perform(click())

        onView(withId(R.id.etFirstNumber))
            .check(matches(hasErrorText("Missing first number")))
    }

    @Test
    fun setsErrorWhenSecondValueIsMissing() {
        onView(withId(R.id.etFirstNumber))
            .perform(typeText("5"), closeSoftKeyboard() )

        onView(withId(R.id.etSecondNumber))
            .perform(typeText(""), closeSoftKeyboard() )

        onView(withId(R.id.bSubtract)).perform(click())

        onView(withId(R.id.etSecondNumber))
            .check(matches(hasErrorText("Missing second number")))
    }

    @Test
    fun setsErrorWhenBothValueIsMissing() {
        onView(withId(R.id.etFirstNumber))
            .perform(typeText(""), closeSoftKeyboard() )

        onView(withId(R.id.etSecondNumber))
            .perform(typeText(""), closeSoftKeyboard() )

        onView(withId(R.id.bSubtract)).perform(click())

        onView(withId(R.id.etFirstNumber))
            .check(matches(hasErrorText("Missing first number")))

        onView(withId(R.id.etSecondNumber))
            .check(matches(hasErrorText("Missing second number")))
    }

    private fun thenEditTextsAreCleared() {
        onView(withId(R.id.etFirstNumber)).check(matches(withText("")))
        onView(withId(R.id.etFirstNumber)).check(matches(withText("")))
    }

}
