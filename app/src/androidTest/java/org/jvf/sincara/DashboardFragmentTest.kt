package org.jvf.sincara

import androidx.fragment.app.testing.launchFragmentInContainer
import androidx.navigation.NavController
import androidx.navigation.Navigation
import androidx.test.espresso.Espresso
import androidx.test.espresso.action.ViewActions
import androidx.test.espresso.assertion.ViewAssertions
import androidx.test.espresso.matcher.ViewMatchers
import androidx.test.ext.junit.runners.AndroidJUnit4
import org.junit.Test
import org.junit.runner.RunWith
import org.jvf.sincara.R
import org.jvf.sincara.ui.dashboard.DashboardFragment
import org.mockito.Mockito.mock
import org.mockito.Mockito.verify

@RunWith(AndroidJUnit4::class)
class DashboardFragmentTest {

    @Test
    fun testNavigationToAngkaFragment() {
        // Meluncurkan fragment Dashboard dalam kontainer pengujian
        val scenario = launchFragmentInContainer<DashboardFragment>()

        // Memastikan bahwa fragment Dashboard ditampilkan
        scenario.onFragment { fragment ->
            Espresso.onView(ViewMatchers.withId(fragment.requireView().id))
                .check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
        }

        // Mendapatkan NavController palsu
        val navController = mock(NavController::class.java)

        // Memberikan NavController palsu ke fragment
        scenario.onFragment { fragment ->
            Navigation.setViewNavController(fragment.requireView(), navController)
        }

        // Memverifikasi tampilan tombol dan melakukan tindakan yang memicu navigasi ke AngkaFragment
        Espresso.onView(ViewMatchers.withId(R.id.tombolAngka))
            .perform(ViewActions.click())

        // Memastikan bahwa navigasi ke AngkaFragment terjadi
        verify(navController).navigate(R.id.action_dashboardFragment_to_angkaFragment)
    }
}