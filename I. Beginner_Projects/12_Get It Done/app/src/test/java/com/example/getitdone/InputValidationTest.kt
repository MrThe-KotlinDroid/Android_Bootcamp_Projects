package com.example.getitdone

import com.example.getitdone.ui.MainActivity
import org.junit.Assert.assertFalse
import org.junit.Test

class InputValidationTest {

    @Test
    fun inputValidator_returnsFalseWhenEmpty() {
        // Perform an action
        val mainActivity = MainActivity()
        val result = mainActivity.isInputValid("")

        // Assert the result
        assertFalse(result)
    }
}