package com.example.newsappassignment.app.ui.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.example.newsappassignment.app.base.BaseViewModel
import com.example.newsappassignment.domain.model.NewsResponse
import com.example.newsappassignment.domain.repo.INewsRepo
import com.example.newsappassignment.domain.utils.ApiResult
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val newsRepo: INewsRepo
) : BaseViewModel() {
    private val _breakingNewsResponse = MutableLiveData<ApiResult<NewsResponse>>()
    val breakingNewsResponse: LiveData<ApiResult<NewsResponse>>
        get() = _breakingNewsResponse

    fun getBreakingNews() {
        viewModelScope.launch(Dispatchers.IO) {
            val response = newsRepo.getBreakingNews(1)
            _breakingNewsResponse.postValue(response)
        }
    }
}