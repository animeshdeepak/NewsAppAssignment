package com.example.newsappassignment.data.repoimpl

import android.app.Application
import android.util.Log
import com.example.newsappassignment.R
import com.example.newsappassignment.data.remote.NewsApi
import com.example.newsappassignment.domain.model.NewsResponse
import com.example.newsappassignment.domain.repo.INewsRepo
import retrofit2.Response
import javax.inject.Inject

class NewsRepoImpl @Inject constructor(
    private val newsApi: NewsApi,
    appContext: Application
) : INewsRepo {

    override suspend fun searchForNews(
        searchQuery: String,
        pageNumber: Int,
    ): Response<NewsResponse> {
        return newsApi.searchForNews(searchQuery = searchQuery, pageNumber = pageNumber)
    }

    override suspend fun getBreakingNews(
        pageNumber: Int,
    ): Response<NewsResponse> {
        return newsApi.getBreakingNews(pageNumber = pageNumber)
    }
}