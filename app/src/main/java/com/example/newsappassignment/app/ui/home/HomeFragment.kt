package com.example.newsappassignment.app.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import com.example.newsappassignment.app.adapter.ArticlesAdapter
import com.example.newsappassignment.app.base.BaseFragment
import com.example.newsappassignment.app.utils.observe
import com.example.newsappassignment.app.utils.showToast
import com.example.newsappassignment.databinding.FragmentHomeBinding
import com.example.newsappassignment.domain.model.NewsResponse
import com.example.newsappassignment.domain.utils.Result
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class HomeFragment : BaseFragment() {
    private lateinit var binding: FragmentHomeBinding
    private val viewModel: HomeViewModel by viewModels()
    private lateinit var articlesAdapter: ArticlesAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentHomeBinding.inflate(inflater, container, false)
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

    private fun handleNewsResponse(response: Result<NewsResponse>) {
        when (response) {
            is Result.Success -> {
                articlesAdapter.submitList(response.data?.articles)
            }

            is Result.Error -> {
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

    companion object {
        fun newInstance(param1: String, param2: String) =
            HomeFragment().apply {
                arguments = Bundle().apply {
//                    putString(ARG_PARAM1, param1)
//                    putString(ARG_PARAM2, param2)
                }
            }
    }
}