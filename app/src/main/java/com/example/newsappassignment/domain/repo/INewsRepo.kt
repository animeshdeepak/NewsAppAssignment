package com.example.newsappassignment.domain.repo

import com.example.newsappassignment.domain.model.NewsResponse
import com.example.newsappassignment.domain.utils.ApiResult

interface INewsRepo {
    suspend fun searchForNews(
        searchQuery: String,
        pageNumber: Int,
    ): ApiResult<NewsResponse>

    suspend fun getBreakingNews(
        pageNumber: Int,
    ): ApiResult<NewsResponse>
}