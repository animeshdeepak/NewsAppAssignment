package com.example.newsappassignment.app.utils

import org.junit.Assert
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.Parameterized
import org.junit.runners.Parameterized.Parameters

@RunWith(value = Parameterized::class)
class ParametrizedChangeDateFormatTest(
    private val dateTimeFormat: String,
    private val input: String,
    private val expectedValue: Boolean
) {
    @Test
    fun changeDateFormat() {
        // Arrange
//        val publishedAt = "2023-06-22T17:56:03Z"
        // Act
        val res: Boolean = try {
            isValidFormat(dateTimeFormat, input.changeDateFormat())
        } catch (e: Exception) {
            false
        }
        // Assert
        Assert.assertEquals(expectedValue, res)
    }

    companion object {
        @JvmStatic
        @Parameters(name = "{index}: Is {0} and {1} datetime are same?. {2}")
        fun data(): List<Array<Any>> {
            return listOf(
                arrayOf("dd.MM.yyyy HH:mm:ss", "2023-06-22T17:56:03Z", true),
                arrayOf("dd.MM.yyyy HH:mm:ss", "2023-06-22", false),
            )
        }
    }
}