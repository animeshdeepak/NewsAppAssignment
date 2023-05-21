package com.example.newsappassignment.domain.repo

import com.example.newsappassignment.domain.model.NewsResponse
import retrofit2.Response

interface INewsRepo {
    suspend fun searchForNews(
        searchQuery: String,
        pageNumber: Int,
    ): Response<NewsResponse>

    suspend fun getBreakingNews(
        pageNumber: Int,
    ): Response<NewsResponse>
}