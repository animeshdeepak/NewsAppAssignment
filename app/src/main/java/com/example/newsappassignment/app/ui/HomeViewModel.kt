package com.example.newsappassignment.app.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.newsappassignment.domain.model.NewsResponse
import com.example.newsappassignment.domain.repo.INewsRepo
import com.example.newsappassignment.domain.utils.Result
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import retrofit2.Response
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val newsRepo: INewsRepo
) : ViewModel() {
    private val _breakingNewsResponse = MutableLiveData<Result<NewsResponse>>()
    val breakingNewsResponse: LiveData<Result<NewsResponse>>
        get() = _breakingNewsResponse

    private val _isLoading = MutableLiveData<Boolean>()
    val isLoading: LiveData<Boolean>
        get() = _isLoading

    init {
        viewModelScope.launch(Dispatchers.IO) {
            _isLoading.postValue(true)
            val response = newsRepo.getBreakingNews(1)
            _breakingNewsResponse.postValue(handleBreakingNewsResponse(response))
        }
    }

    private fun handleBreakingNewsResponse(response: Response<NewsResponse>): Result<NewsResponse> {
        _isLoading.postValue(false)
        if (response.isSuccessful) {
            response.body()?.let { resultResponse ->
                return Result.Success(resultResponse)
            }
        }
        return Result.Error(response.message())
    }
}