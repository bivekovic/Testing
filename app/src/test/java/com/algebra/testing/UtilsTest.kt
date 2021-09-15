package com.algebra.testing

import com.algebra.testing.utils.*
import org.junit.Test

import org.junit.Assert.*

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
class UtilsTest {
    @Test
    fun addition_isCorrect() {
        val result = add(1, 2)
        assertTrue(result == 3)
    }

    @Test
    fun subtraction_isCorrect() {
        val result = subtract(1, 2)
        assertTrue(result == -1)
    }

    @Test
    fun multiplication_isCorrect() {
        val result = multiply(1, 2)
        assertTrue(result == 2)
    }

    @Test
    fun division_isCorrect() {
        val result = divide(4, 2)
        assertTrue(result == 2)
    }

    @Test
    fun transformsValidStringToNumberCorrectly() {
        val result = transformToNumber("6")
        assertTrue(result == 6)
    }

    @Test
    fun transformsEmptyStringToNull() {
        val result = transformToNumber("")
        assertNull(result)
    }

    @Test
    fun transformsInvalidStringToNull1() {
        val result = transformToNumber("d")
        assertNull(result)
    }

}
