package com.example.newsappassignment.app.ui.home

import android.os.Bundle
import android.view.View
import androidx.activity.viewModels
import com.example.newsappassignment.app.adapter.ArticlesAdapter
import com.example.newsappassignment.app.base.BaseActivity
import com.example.newsappassignment.app.utils.observe
import com.example.newsappassignment.app.utils.showToast
import com.example.newsappassignment.databinding.ActivityMainBinding
import com.example.newsappassignment.domain.model.NewsResponse
import com.example.newsappassignment.domain.utils.Result
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class HomeActivity : BaseActivity() {
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

    override fun initUI() {
        articlesAdapter = ArticlesAdapter()
        articlesAdapter.onItemClick = {
            this.showToast(it)
        }
        binding.recyclerView.apply {
            adapter = articlesAdapter
            setHasFixedSize(true)
        }
    }

    override fun initObserve() {
        observe(viewModel.breakingNewsResponse, ::handleNewsResponse)
        observe(viewModel.isLoading, ::handlerLoader)
    }

    private fun handleNewsResponse(response: Result<NewsResponse>) {
        when (response) {
            is Result.Success -> {
                articlesAdapter.submitList(response.data?.articles)
            }

            is Result.Error -> {
                this.showToast("${response.message}")
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