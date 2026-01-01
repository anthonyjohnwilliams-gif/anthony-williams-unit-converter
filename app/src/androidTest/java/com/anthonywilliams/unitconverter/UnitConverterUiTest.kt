package com.anthonywilliams.unitconverter

import androidx.compose.ui.test.assertTextContains
import androidx.compose.ui.test.junit4.createAndroidComposeRule
import androidx.compose.ui.test.onNodeWithTag
import androidx.compose.ui.test.performClick
import androidx.compose.ui.test.performTextClearance
import androidx.compose.ui.test.performTextInput
import org.junit.Rule
import org.junit.Test

class UnitConverterUiTest {

    @get:Rule
    val composeRule = createAndroidComposeRule<MainActivity>()

    @Test
    fun convert_validInput_showsFahrenheitOutput() {
        composeRule.onNodeWithTag("inputField")
            .performTextClearance()
            .performTextInput("0")

        composeRule.onNodeWithTag("convertButton")
            .performClick()

        composeRule.onNodeWithTag("outputText")
            .assertTextContains("32.00 °F")
    }

    @Test
    fun convert_invalidInput_showsErrorMessage() {
        composeRule.onNodeWithTag("inputField")
            .performTextClearance()
            .performTextInput("abc")

        composeRule.onNodeWithTag("convertButton")
            .performClick()

        composeRule.onNodeWithTag("outputText")
            .assertTextContains("Invalid number")
    }
}
