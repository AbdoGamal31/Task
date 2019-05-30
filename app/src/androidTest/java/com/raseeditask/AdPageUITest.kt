package com.raseeditask

import android.content.Context
import androidx.test.core.app.ApplicationProvider.getApplicationContext
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.contrib.RecyclerViewActions
import androidx.test.espresso.matcher.ViewMatchers
import androidx.test.espresso.matcher.ViewMatchers.isDisplayed
import androidx.test.espresso.matcher.ViewMatchers.withText
import androidx.test.ext.junit.rules.ActivityScenarioRule
import com.raseeditask.ui.MainActivity
import com.raseeditask.ui.adlistadapter.AdListAdapter
import org.junit.Rule
import org.junit.Test


/**
 * this class use for UI test
 *
 *
 * @author  Abdo Gamal
 * @version 1.0
 * @since   29-5-2019
 */

class AdPageUITest {

    private val VALID_POSITION = 5
    private val INVALID_POSITION = 115

    @get:Rule
    public var activityScenarioRule = ActivityScenarioRule<MainActivity>(MainActivity::class.java)

    /**
     * this function used for UI test on Recycler View that will scroll to the valid position
     * @author  Abdo Gamal
     * @version 1.0
     * @since   29-5-2019
     */
    @Test
    fun scrollToValidPosition() {
        onView(ViewMatchers.withId(R.id.ad_card_list))
            .perform(RecyclerViewActions.scrollToPosition<AdListAdapter.DataViewHolder>(VALID_POSITION))

    }

    /**
     * this function used for UI test on Recycler View that will scroll to the invalid position
     * so no scroll will happened
     * @author  Abdo Gamal
     * @version 1.0
     * @since   29-5-2019
     */
    @Test
    fun scrollToInValidPosition() {
        onView(ViewMatchers.withId(R.id.ad_card_list))
            .perform(RecyclerViewActions.scrollToPosition<AdListAdapter.DataViewHolder>(INVALID_POSITION))

    }

    /**
     * this function used for UI test on Recycler View that will scroll to the valid position and perform click on it
     * @author  Abdo Gamal
     * @version 1.0
     * @since   29-5-2019
     */
    @Test
    fun scrollToValidPositionAndClickOnIt() {
        onView(ViewMatchers.withId(R.id.ad_card_list))
            .perform(
                RecyclerViewActions.actionOnItemAtPosition<AdListAdapter.DataViewHolder>(
                    INVALID_POSITION,
                    click()
                )
            )
    }

}