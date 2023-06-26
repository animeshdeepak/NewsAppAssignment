package com.example.newsappassignment.app.utils

import java.text.ParseException
import java.text.SimpleDateFormat
import java.util.Date

fun isValidFormat(format: String?, value: String): Boolean {
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