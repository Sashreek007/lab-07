package com.example.lab_7

import androidx.compose.ui.test.junit4.createAndroidComposeRule
import androidx.compose.ui.test.onNodeWithTag
import androidx.compose.ui.test.onNodeWithText
import androidx.compose.ui.test.performClick
import androidx.compose.ui.test.performTextInput
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.example.lab_07.MainActivity
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class DriversScreenTest {

    @get:Rule
    val composeTestRule = createAndroidComposeRule<MainActivity>()

    @Test
    fun navigate_to_drivers_add_clear_and_return_home() {
        // 1. home -> drivers
        composeTestRule.onNodeWithTag("driversButton").performClick()
        composeTestRule.onNodeWithText("FormulaZero Drivers").assertExists()

        // 2. add drivers and verify they show up
        composeTestRule.onNodeWithTag("driverInput").performTextInput("Max Verstappen")
        composeTestRule.onNodeWithTag("addDriverButton").performClick()
        composeTestRule.onNodeWithText("Max Verstappen").assertExists()

        composeTestRule.onNodeWithTag("driverInput").performTextInput("Lewis Hamilton")
        composeTestRule.onNodeWithTag("addDriverButton").performClick()
        composeTestRule.onNodeWithText("Lewis Hamilton").assertExists()

        // 3. clear and verify the list is empty
        composeTestRule.onNodeWithTag("clearDriversButton").performClick()
        composeTestRule.onNodeWithText("Max Verstappen").assertDoesNotExist()
        composeTestRule.onNodeWithText("Lewis Hamilton").assertDoesNotExist()

        // 4. back -> home
        composeTestRule.onNodeWithTag("driversBackButton").performClick()
        composeTestRule.onNodeWithText("FormulaZero Home").assertExists()
        composeTestRule.onNodeWithText("FormulaZero Drivers").assertDoesNotExist()
    }
}