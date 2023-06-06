package com.example.newsappassignment.domain.repo

interface IDataStorePref {
    suspend fun setSkipOnboard(key: String, value: Boolean)
    suspend fun getSkipOnboard(key: String): Boolean?
}