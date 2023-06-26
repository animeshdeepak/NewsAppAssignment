package com.example.newsappassignment.app.utils

import org.junit.After
import org.junit.Assert.*
import org.junit.Before

import org.junit.Test
import java.text.ParseException
import java.text.SimpleDateFormat
import java.util.Date

class DateManagerKtTest {

    @Before
    fun setUp() {
        println("Before Every Test Case")
    }

    @After
    fun tearDown() {
        println("After Every Test Case")
    }

    @Test
    fun changeDateFormat_positive() {
        // Arrange
        val publishedAt = "2023-06-22T17:56:03Z"
        // Act
        val res = isValidFormat("dd.MM.yyyy HH:mm:ss", publishedAt.changeDateFormat())
        // Assert
        assertEquals(true, res)
    }

    @Test
    fun changeDateFormat_negative() {
        // Arrange
        val publishedAt = "2023-06-22"
        // Act
        val res: Boolean = try {
            isValidFormat("dd.MM.yyyy HH:mm:ss", publishedAt.changeDateFormat())
        } catch (e: Exception) {
            false
        }
        // Assert
        assertEquals(false, res)
    }

    @Test
    fun changeDateFormat_input_blank_negative_case() {
        // Arrange
        val publishedAt = ""
        // Act
        val res: Boolean = try {
            isValidFormat("dd.MM.yyyy HH:mm:ss", publishedAt.changeDateFormat())
        } catch (e: Exception) {
            false
        }
        // Assert
        assertEquals(false, res)
    }

    @Test
    fun hourAgoFormat_positive() {
        // Arrange
        val publishedAt = "2023-06-22T17:56:03Z"
        // Act
        val res = isValidFormat("HH:mm:ss", publishedAt.hourAgoFormat())
        // Assert
        assertEquals(true, res)
    }

    @Test
    fun hourAgoFormat_input_empty_negative_case() {
        // Arrange
        val publishedAt = ""
        // Act
        val res = publishedAt.hourAgoFormat()
        // Assert
        assertEquals("", res)
    }

    @Test
    fun currentTime_if_not_null_positive_case() {
        // Arrange
        val currentTime = currentTime()
        // Act
        val res = try {
            currentTime.isNotBlank() || currentTime.isNotEmpty()
        } catch (e: Exception) {
            false
        }
        // Assert
        assertEquals(true, res)
    }

    private fun isValidFormat(format: String?, value: String): Boolean {
        var date: Date? = null
        try {
            val sdf = SimpleDateFormat(format)
            date = sdf.parse(value)
            date?.let {
                if (value != sdf.format(it)) {
                    date = null
                }
            }
        } catch (ex: ParseException) {
//            ex.printStackTrace()
        }
        return date != null
    }
}