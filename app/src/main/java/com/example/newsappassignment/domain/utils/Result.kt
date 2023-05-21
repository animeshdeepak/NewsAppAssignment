package com.example.newsappassignment.domain.utils

sealed class Result<out T>(
    val data: T? = null,
    val message: String? = null,
) {
    class Success<T>(data: T) : Result<T>(data)
    class Error<T>(message: String, data: T? = null) : Result<T>(data, message)
}