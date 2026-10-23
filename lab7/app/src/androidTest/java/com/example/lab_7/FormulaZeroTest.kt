package com.example.lab_7

import androidx.compose.ui.test.junit4.createAndroidComposeRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import androidx.compose.ui.test.onNodeWithTag
import androidx.compose.ui.test.onNodeWithText
import androidx.compose.ui.test.performClick
import androidx.compose.ui.test.performTextInput
import androidx.test.espresso.Espresso

@RunWith(AndroidJUnit4::class)
class FormulaZeroTest {
    @get:Rule
    val composeTestRule = createAndroidComposeRule<MainActivity>() // access MainActivity

    @Test
    fun navigate_to_races_add_race_and_return_home() {
        // navigate to race screen
        composeTestRule
            .onNodeWithTag("raceButton")
            .performClick()

        // verify race screen
        composeTestRule
            .onNodeWithText("Upcoming Races")
            .assertExists()

        // enter race location
        composeTestRule
            .onNodeWithTag("locationInput")
            .performTextInput("Canada")

        // add race location
        composeTestRule
            .onNodeWithTag("addRaceButton")
            .performClick()

        // verify race appears
        composeTestRule
            .onNodeWithText("Canada")
            .assertExists()

        // return to home screen
        composeTestRule
            .onNodeWithTag("backButton")
            .performClick()

        // verify return to home screen
        composeTestRule
            .onNodeWithText("FormulaZero Home")
            .assertExists()
    }

    @Test
    fun navigate_to_drivers_add_driver_clear_and_return_home() {

        // Navigate to drivers screen
        composeTestRule
            .onNodeWithTag("driversButton")
            .performClick()

        // Verify drivers screen
        composeTestRule
            .onNodeWithText("FormulaZero Drivers")
            .assertExists()

        // Enter driver name
        composeTestRule
            .onNodeWithTag("driverInput")
            .performTextInput("Canada")

        // Add driver
        composeTestRule
            .onNodeWithTag("addDriverButton")
            .performClick()

        // Verify driver appears
        composeTestRule
            .onNodeWithText("Canada")
            .assertExists()

        // Clear drivers
        composeTestRule
            .onNodeWithTag("clearButton")
            .performClick()

        // Verify driver is cleared
        composeTestRule
            .onNodeWithText("Canada")
            .assertDoesNotExist()

        // Return to home screen
        composeTestRule
            .onNodeWithTag("backButton")
            .performClick()

        // Verify return to home screen
        composeTestRule
            .onNodeWithText("FormulaZero Home")
            .assertExists()
    }
}
