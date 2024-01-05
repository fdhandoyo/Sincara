package org.jvf.sincara


import android.view.View
import android.view.ViewGroup
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.Espresso.pressBack
import androidx.test.espresso.action.ViewActions.*
import androidx.test.espresso.assertion.ViewAssertions.*
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.filters.LargeTest
import androidx.test.rule.GrantPermissionRule
import org.hamcrest.Description
import org.hamcrest.Matcher
import org.hamcrest.Matchers.allOf
import org.hamcrest.Matchers.`is`
import org.hamcrest.TypeSafeMatcher
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@LargeTest
@RunWith(AndroidJUnit4::class)
class SincaraTest {

    @Rule
    @JvmField
    var mActivityScenarioRule = ActivityScenarioRule(SplashActivity::class.java)

    @Rule
    @JvmField
    var mGrantPermissionRule =
        GrantPermissionRule.grant(
            "android.permission.POST_NOTIFICATIONS"
        )

    @Test
    fun sincaraTest() {
        val materialButton = onView(
            allOf(
                withId(R.id.loginGoogle), withText("Login With Google"),
                childAtPosition(
                    childAtPosition(
                        withId(R.id.myNavHostFragment),
                        0
                    ),
                    0
                ),
                isDisplayed()
            )
        )
        materialButton.perform(click())

        val appCompatImageButton = onView(
            allOf(
                withId(R.id.tombolAlfabet), withContentDescription("Alphabet Bahasa Isyarat"),
                childAtPosition(
                    childAtPosition(
                        withClassName(`is`("android.widget.ScrollView")),
                        0
                    ),
                    6
                )
            )
        )
        appCompatImageButton.perform(scrollTo(), click())

        pressBack()

        val appCompatImageButton2 = onView(
            allOf(
                withId(R.id.tombolAngka), withContentDescription("Angka Bahasa Isyarat"),
                childAtPosition(
                    childAtPosition(
                        withClassName(`is`("android.widget.ScrollView")),
                        0
                    ),
                    9
                )
            )
        )
        appCompatImageButton2.perform(scrollTo(), click())

        pressBack()

        val appCompatImageButton3 = onView(
            allOf(
                withId(R.id.tombolKomnunikasi), withContentDescription("Tips dan Trik Belajar"),
                childAtPosition(
                    childAtPosition(
                        withClassName(`is`("android.widget.ScrollView")),
                        0
                    ),
                    12
                )
            )
        )
        appCompatImageButton3.perform(scrollTo(), click())

        val materialButton2 = onView(
            allOf(
                withId(R.id.button2),
                withText("Meningkatkan Keterampilan Isyarat Bahasa Isyarat melalui Latihan Sehari-hari"),
                childAtPosition(
                    childAtPosition(
                        withClassName(`is`("android.widget.ScrollView")),
                        0
                    ),
                    1
                )
            )
        )
        materialButton2.perform(scrollTo(), click())

        pressBack()

        val materialButton3 = onView(
            allOf(
                withId(R.id.button3),
                withText("Mengatasi Rasa Malu dan Meningkatkan Kepercayaan Diri dalam Menggunakan Bahasa Isyarat"),
                childAtPosition(
                    childAtPosition(
                        withClassName(`is`("android.widget.ScrollView")),
                        0
                    ),
                    2
                )
            )
        )
        materialButton3.perform(scrollTo(), click())

        pressBack()

        val materialButton4 = onView(
            allOf(
                withId(R.id.button4),
                withText("Memahami Perbedaan Kultur dalam Bahasa Isyarat untuk Komunikasi yang Lebih Baik"),
                childAtPosition(
                    childAtPosition(
                        withClassName(`is`("android.widget.ScrollView")),
                        0
                    ),
                    3
                )
            )
        )
        materialButton4.perform(scrollTo(), click())

        pressBack()

        val materialButton5 = onView(
            allOf(
                withId(R.id.button5),
                withText("Mengatasi Kendala dalam Belajar Bahasa Isyarat dengan Mudah"),
                childAtPosition(
                    childAtPosition(
                        withClassName(`is`("android.widget.ScrollView")),
                        0
                    ),
                    4
                )
            )
        )
        materialButton5.perform(scrollTo(), click())

        pressBack()

        val materialButton6 = onView(
            allOf(
                withId(R.id.button6),
                withText("Meningkatkan Kosa Kata Bahasa Isyarat dengan Cara yang Mudah"),
                childAtPosition(
                    childAtPosition(
                        withClassName(`is`("android.widget.ScrollView")),
                        0
                    ),
                    5
                )
            )
        )
        materialButton6.perform(scrollTo(), click())

        pressBack()

        pressBack()

        val appCompatImageButton4 = onView(
            allOf(
                withId(R.id.tombolKamus), withContentDescription("Sejarah Bahasa Isyarat"),
                childAtPosition(
                    childAtPosition(
                        withClassName(`is`("android.widget.ScrollView")),
                        0
                    ),
                    15
                )
            )
        )
        appCompatImageButton4.perform(scrollTo(), click())

        pressBack()

        val appCompatImageButton5 = onView(
            allOf(
                withId(R.id.profileButton),
                childAtPosition(
                    childAtPosition(
                        withClassName(`is`("android.widget.ScrollView")),
                        0
                    ),
                    18
                )
            )
        )
        appCompatImageButton5.perform(scrollTo(), click())

        val materialButton7 = onView(
            allOf(
                withId(R.id.butLogout), withText("Logout"),
                childAtPosition(
                    childAtPosition(
                        withId(R.id.myNavHostFragment),
                        0
                    ),
                    9
                ),
                isDisplayed()
            )
        )
        materialButton7.perform(click())
    }

    private fun childAtPosition(
        parentMatcher: Matcher<View>, position: Int
    ): Matcher<View> {

        return object : TypeSafeMatcher<View>() {
            override fun describeTo(description: Description) {
                description.appendText("Child at position $position in parent ")
                parentMatcher.describeTo(description)
            }

            public override fun matchesSafely(view: View): Boolean {
                val parent = view.parent
                return parent is ViewGroup && parentMatcher.matches(parent)
                        && view == parent.getChildAt(position)
            }
        }
    }
}
