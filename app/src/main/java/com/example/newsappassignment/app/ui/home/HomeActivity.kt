package com.example.newsappassignment.app.ui.home

import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.example.newsappassignment.app.adapter.ArticlesAdapter
import com.example.newsappassignment.app.utils.observe
import com.example.newsappassignment.app.utils.showToast
import com.example.newsappassignment.databinding.ActivityMainBinding
import com.example.newsappassignment.domain.model.NewsResponse
import com.example.newsappassignment.domain.utils.Result
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class HomeActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private val viewModel: HomeViewModel by viewModels()
    private lateinit var articlesAdapter: ArticlesAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        initUI()
        initObserve()
    }

    private fun initUI() {
        articlesAdapter = ArticlesAdapter()
        articlesAdapter.onItemClick = {
            this.showToast(it)
        }
        binding.recyclerView.apply {
            adapter = articlesAdapter
            setHasFixedSize(true)
        }
    }

    private fun initObserve() {
        observe(viewModel.breakingNewsResponse, ::handleNewsResponse)
        observe(viewModel.isLoading, ::handlerLoader)
    }

    private fun handleNewsResponse(response: Result<NewsResponse>) {
        when (response) {
            is Result.Success -> {
                articlesAdapter.submitList(response.data?.articles)
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