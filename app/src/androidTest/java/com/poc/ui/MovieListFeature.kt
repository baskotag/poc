package com.poc.ui

import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.rule.ActivityTestRule
import com.poc.R
import kotlinx.coroutines.delay
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class MovieListFeature {
    val mActivityTestRule = ActivityTestRule(MainActivity::class.java)
        @Rule get

    @Test
    suspend fun displayScreenTitle() {
        onView(withId(R.id.rootView))
            .check(matches(withEffectiveVisibility(Visibility.VISIBLE)))
        delay(3000)
        onView(withId(R.id.toolbar))
            .check(matches(withEffectiveVisibility(Visibility.VISIBLE)))
        onView(withId(R.id.toolbar))
            .check(matches(withText(R.string.home)))
    }

    @Test
    fun displayListOfMovies() {
       //assertRe

    }
}