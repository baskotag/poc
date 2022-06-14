package com.poc.ui

import androidx.fragment.app.testing.FragmentScenario
import androidx.fragment.app.testing.launchFragmentInContainer
import androidx.lifecycle.Lifecycle
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.poc.R
import junit.framework.TestCase
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class HomeFragmentTest : TestCase() {
    private lateinit var scenario: FragmentScenario<HomeFragment>

    @Before
    fun setup() {
        scenario = launchFragmentInContainer(themeResId = R.style.Theme_POC)
        scenario.moveToState(Lifecycle.State.STARTED)
    }

    @Test
    fun testUIData() {
        onView(withId(R.id.tvName)).check { _, _ -> }
        onView(withId(R.id.tvAuthor)).check { _, _ -> }
        onView(withId(R.id.placeImage)).check { _, _ -> }
    }


}
