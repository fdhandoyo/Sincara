package org.jvf.sincara

import androidx.test.core.app.ActivityScenario
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.ext.junit.runners.AndroidJUnit4
import org.junit.Test
import org.junit.runner.RunWith


@RunWith(AndroidJUnit4::class)
class MainActivityTest {
    @Test
    fun testButtonDashboard() {
        // Jalankan MainActivity
        val activityScenario = ActivityScenario.launch(MainActivity::class.java)

        // Lakukan aksi
        onView(withId(R.id.tombolAngka)).perform(click())
        onView(withId(R.id.tombolAlfabet)).perform(click())
        onView(withId(R.id.tombolKomnunikasi)).perform(click())
        onView(withId(R.id.profileButton)).perform(click())

        // Cek apakah data tersebut muncul
        onView(withId(R.id.tombolAngka)).check(matches(isDisplayed()))
        onView(withId(R.id.tombolAlfabet)).check(matches(isDisplayed()))
        onView(withId(R.id.tombolKomnunikasi)).check(matches(isDisplayed()))
        onView(withId(R.id.profileButton)).check(matches(isDisplayed()))

        // Tes selesai, tutup activity nya
        activityScenario.close()
    }
}