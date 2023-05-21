package com.example.newsappassignment.app.ui

import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.example.newsappassignment.app.utils.observe
import com.example.newsappassignment.databinding.ActivityMainBinding
import com.example.newsappassignment.domain.model.NewsResponse
import com.example.newsappassignment.domain.utils.Result
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class HomeActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private val viewModel: HomeViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        initUI()
        initObserve()
    }

    private fun initUI() {

    }

    private fun initObserve() {
        observe(viewModel.breakingNewsResponse, ::handleNewsResponse)
        observe(viewModel.isLoading, ::handlerLoader)
    }

    private fun handleNewsResponse(response: Result<NewsResponse>) {
        viewModel._isLoading.value = false
        when (response) {
            is Result.Success -> {
                Log.d("DPK", "Success: ${response.data?.articles}")
            }

            is Result.Error -> {
                Log.d("DPK", "Error: ${response.message}")
            }
        }
    }

    private fun handlerLoader(flag: Boolean) {
        if (flag)
            binding.progressBar.visibility = View.VISIBLE
        else
            binding.progressBar.visibility = View.GONE
    }

}