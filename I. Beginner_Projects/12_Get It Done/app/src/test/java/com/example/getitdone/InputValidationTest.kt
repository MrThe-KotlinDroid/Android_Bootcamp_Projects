package com.example.getitdone

import com.example.getitdone.ui.MainActivity
import com.example.getitdone.util.InputValidator
import org.junit.Assert.assertFalse
import org.junit.Test

class InputValidationTest {

    @Test
    fun inputValidator_returnsFalseWhenEmpty() {
        // Perform an action
        val result = InputValidator.isInputValid("")

        // Assert the result
        assertFalse(result)
    }
}