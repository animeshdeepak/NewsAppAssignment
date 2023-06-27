package com.example.newsappassignment.data.repoimpl

import com.example.newsappassignment.data.remote.NewsApi
import com.example.newsappassignment.domain.model.NewsResponse
import com.example.newsappassignment.domain.repo.INewsRepo
import com.example.newsappassignment.domain.utils.ApiResult
import javax.inject.Inject

class NewsRepoImpl @Inject constructor(
    private val newsApi: NewsApi,
) : INewsRepo {

    override suspend fun searchForNews(
        searchQuery: String,
        pageNumber: Int,
    ): ApiResult<NewsResponse> {
        val response = newsApi.searchForNews(searchQuery = searchQuery, pageNumber = pageNumber)
        if (response.isSuccessful) {
            response.body()?.let { resultResponse ->
                return ApiResult.Success(resultResponse)
            }
        }
        return ApiResult.Error(response.message())
    }

    override suspend fun getBreakingNews(
        pageNumber: Int,
    ): ApiResult<NewsResponse> {
        val response = newsApi.getBreakingNews(pageNumber = pageNumber)
        if (response.isSuccessful) {
            response.body()?.let { resultResponse ->
                return ApiResult.Success(resultResponse)
            }
        }
        return ApiResult.Error(response.message())
    }
}