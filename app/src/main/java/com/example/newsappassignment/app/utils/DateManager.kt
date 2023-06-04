package com.example.newsappassignment.app.utils

import android.util.Log
import java.text.DateFormat
import java.text.SimpleDateFormat
import java.util.Calendar
import java.util.Locale

fun String?.changeDateFormat(): String {
    if (this.isNullOrEmpty()) {
        return ""
    }
    return try {
        val sourceSdf = SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss", Locale.getDefault())
        val requiredSdf = SimpleDateFormat("dd.MM.yyyy HH:mm:ss", Locale.getDefault())
        requiredSdf.format(sourceSdf.parse(this)!!)
    } catch (ex: Exception) {
        Log.e("DPK", "ex: ${ex.message}")
        ""
    }
}

fun String?.hourAgoFormat(): String {
    if (this.isNullOrEmpty()) {
        return ""
    }
    return try {
        val sourceSdf = SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss", Locale.getDefault())
        val requiredSdf = SimpleDateFormat("HH:mm:ss", Locale.getDefault())
        requiredSdf.format(sourceSdf.parse(this)!!)
    } catch (ex: Exception) {
        Log.e("DPK", "ex: ${ex.message}")
        ""
    }
}

fun currentTime(): String {
    return try {
        val cal: Calendar = Calendar.getInstance()
        val formatter: DateFormat = SimpleDateFormat("MMMM dd", Locale.getDefault())
        return formatter.format(cal.time)
    } catch (ex: Exception) {
        Log.e("DPK", "ex: ${ex.message}")
        ""
    }
}