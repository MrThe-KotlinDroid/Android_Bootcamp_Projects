package com.example.getitdone

import com.example.getitdone.util.InputValidator
import org.junit.Assert.assertFalse
import org.junit.Assert.assertTrue
import org.junit.Test

class InputValidationTest {

    @Test
    fun inputValidator_returnsFalseWhenEmpty() {
        // Perform an action
        val result = InputValidator.isInputValid("")

        // Assert the result
        assertFalse(result)
    }

    @Test
    fun inputValidator_returnsFalseWhenNull() {
        // Perform an action
        val result = InputValidator.isInputValid(null)

        // Assert the result
        assertFalse(result)
    }

    @Test
    fun inputValidator_returnsFalseWhenOnlyWhiteSpace() {
        // Perform an action
        val result = InputValidator.isInputValid("      ")

        // Assert the result
        assertFalse(result)
    }

    @Test
    fun inputValidator_returnsTrueWhenMoreThanOneNonWhiteSpaceCharacter() {
        // Perform an action
        val result = InputValidator.isInputValid("more than one character")

        // Assert the result
        assertTrue(result)
    }

    @Test
    fun inputValidator_returnsFalseWhenOnlyNonWhiteSpaceCharacter() {
        // Perform an action
        val result = InputValidator.isInputValid("a")

        // Assert the result
        assertFalse(result)
    }
}