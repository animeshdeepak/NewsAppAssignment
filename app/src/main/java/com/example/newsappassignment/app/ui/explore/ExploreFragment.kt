package com.example.newsappassignment.app.ui.explore

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import com.example.newsappassignment.app.adapter.ArticlesAdapter
import com.example.newsappassignment.app.base.BaseFragment
import com.example.newsappassignment.app.utils.observe
import com.example.newsappassignment.app.utils.showToast
import com.example.newsappassignment.databinding.FragmentExploreBinding
import com.example.newsappassignment.domain.model.NewsResponse
import com.example.newsappassignment.domain.utils.ApiResult
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class ExploreFragment : BaseFragment() {
    private val viewModel: ExploreViewModel by viewModels()
    private lateinit var articlesAdapter: ArticlesAdapter

    private lateinit var binding: FragmentExploreBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentExploreBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initUI()
        initObserve()
    }

    private fun initUI() {
        articlesAdapter = ArticlesAdapter()
        articlesAdapter.onItemClick = {
            activity?.showToast(it)
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

    private fun handleNewsResponse(response: ApiResult<NewsResponse>) {
        when (response) {
            is ApiResult.Success -> {
                articlesAdapter.submitList(response.data?.articles)
            }

            is ApiResult.Error -> {
                activity?.showToast("${response.message}")
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