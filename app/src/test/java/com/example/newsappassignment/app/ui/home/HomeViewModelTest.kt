package com.example.newsappassignment.app.ui.home

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.example.newsappassignment.app.utils.getOrAwaitValue
import com.example.newsappassignment.domain.model.NewsResponse
import com.example.newsappassignment.domain.repo.INewsRepo
import com.example.newsappassignment.domain.utils.ApiResult
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.StandardTestDispatcher
import kotlinx.coroutines.test.resetMain
import kotlinx.coroutines.test.runTest
import kotlinx.coroutines.test.setMain
import org.junit.Assert.*

import org.junit.After
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.MockitoAnnotations

class HomeViewModelTest {

    @Mock
    lateinit var repo: INewsRepo

    @get : Rule
    val instantTaskExecutorRule = InstantTaskExecutorRule()

    @OptIn(ExperimentalCoroutinesApi::class)
    private val testDispatcher = StandardTestDispatcher()

    @OptIn(ExperimentalCoroutinesApi::class)
    @Before
    fun setUp() {
        // helps to init @Mock annotation variables
        MockitoAnnotations.openMocks(this)
        Dispatchers.setMain(testDispatcher)
    }

    @OptIn(ExperimentalCoroutinesApi::class)
    @After
    fun tearDown() {
        Dispatchers.resetMain()
    }

    @OptIn(ExperimentalCoroutinesApi::class)
    @Test
    fun getBreakingNewsResponse_success() = runTest {
        Mockito.`when`(repo.getBreakingNews(1)).thenReturn(ApiResult.Success(NewsResponse()))
        val sut = HomeViewModel(repo)
        sut.getBreakingNews()

        testDispatcher.scheduler.advanceUntilIdle()
        val result = sut.breakingNewsResponse.getOrAwaitValue()
        assertEquals(0, result.data?.articles?.size)
    }

    @OptIn(ExperimentalCoroutinesApi::class)
    @Test
    fun getBreakingNewsResponse_error() = runTest {
        Mockito.`when`(repo.getBreakingNews(1)).thenReturn(ApiResult.Error("Something went wrong!"))
        val sut = HomeViewModel(repo)
        sut.getBreakingNews()

        testDispatcher.scheduler.advanceUntilIdle()
        val result = sut.breakingNewsResponse.getOrAwaitValue()
        assertEquals(true, result is ApiResult.Error)
        assertEquals("Something went wrong!", result.message)
    }
}