package org.jvf.sincara

import androidx.fragment.app.testing.FragmentScenario
import androidx.fragment.app.testing.launchFragmentInContainer
import androidx.test.espresso.Espresso
import androidx.test.espresso.action.ViewActions
import androidx.test.espresso.assertion.ViewAssertions
import androidx.test.espresso.matcher.ViewMatchers
import androidx.test.ext.junit.runners.AndroidJUnit4
import org.junit.Test
import org.junit.runner.RunWith
import org.jvf.sincara.ui.profile.ProfileFragment

@RunWith(AndroidJUnit4::class)
class ProfileFragmentTest {

    @Test
    fun testProfileDataDisplayed() {
        // Launch Fragment
        val scenario: FragmentScenario<ProfileFragment> = launchFragmentInContainer()

        // Verify profile data is displayed
        Espresso.onView(ViewMatchers.withId(R.id.textEmailnya))
            .check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
        Espresso.onView(ViewMatchers.withId(R.id.textNamanya))
            .check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
        Espresso.onView(ViewMatchers.withId(R.id.textNomornya))
            .check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
        Espresso.onView(ViewMatchers.withId(R.id.profUsername))
            .check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
    }

    @Test
    fun testLogout() {
        // Launch Fragment
        val scenario: FragmentScenario<ProfileFragment> = launchFragmentInContainer()

        // Click logout button
        Espresso.onView(ViewMatchers.withId(R.id.butLogout)).perform(ViewActions.click())

        // Verify navigated to LoginFragment
        Espresso.onView(ViewMatchers.withId(R.id.textEmailnya))
            .check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
    }
}