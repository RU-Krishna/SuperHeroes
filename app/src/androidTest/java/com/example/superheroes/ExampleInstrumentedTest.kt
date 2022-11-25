package com.example.superheroes

import android.content.Context
import androidx.compose.ui.test.*
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.platform.app.InstrumentationRegistry
import com.example.superheroes.ui.theme.SuperHeroesTheme
import org.junit.Assert.*
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

/**
 * Instrumented test, which will execute on an Android device.
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
@RunWith(AndroidJUnit4::class)
class ExampleInstrumentedTest {

    private val appContext: Context = InstrumentationRegistry.getInstrumentation().targetContext

    @get: Rule
    val composeTestRule = createComposeRule()

    @Test
    fun scrollingList() {
        composeTestRule.setContent {
            SuperHeroesTheme {
                SuperHeroScreen()
            }
        }

        composeTestRule
            .onNodeWithText(appContext.getString(R.string.ant_man))
            .performScrollTo()


    }


}