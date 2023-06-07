package com.example.newsappassignment.app.ui.home

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import com.example.newsappassignment.R
import com.example.newsappassignment.app.base.BaseFragment
import com.example.newsappassignment.app.utils.currentTime
import com.example.newsappassignment.app.utils.hourAgoFormat
import com.example.newsappassignment.app.utils.loadImage
import com.example.newsappassignment.app.utils.navigateToNext
import com.example.newsappassignment.app.utils.observe
import com.example.newsappassignment.app.utils.showToast
import com.example.newsappassignment.databinding.FragmentHomeBinding
import com.example.newsappassignment.domain.model.Articles
import com.example.newsappassignment.domain.model.NewsResponse
import com.example.newsappassignment.domain.utils.Result
import com.google.android.material.tabs.TabLayout
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class HomeFragment : BaseFragment() {
    private lateinit var binding: FragmentHomeBinding
    private val viewModel: HomeViewModel by viewModels()

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
        setUpCategoryTabLayout()
        binding.viewMoreTv.setOnClickListener {
            navigateToNext(R.id.action_homeFragment_to_topicsFragment)
        }
    }

    private fun setUpCategoryTabLayout() {
        binding.categoryTl.apply {
            addTab(newTab().setText("All"))
            addTab(newTab().setText("Business"))
            addTab(newTab().setText("Crypto"))
            addTab(newTab().setText("Gaming"))
            addTab(newTab().setText("Technology"))

            addOnTabSelectedListener(object : TabLayout.OnTabSelectedListener {
                override fun onTabSelected(tab: TabLayout.Tab?) {
                    activity?.showToast(tab?.text.toString())
                }

                override fun onTabUnselected(tab: TabLayout.Tab?) = Unit

                override fun onTabReselected(tab: TabLayout.Tab?) = Unit
            })
        }

    }

    private fun initObserve() {
        observe(viewModel.isLoading, ::handlerLoader)
        observe(viewModel.breakingNewsResponse, ::handleNewsResponse)
    }

    private fun handlerLoader(flag: Boolean) {
        if (flag)
            binding.progressBar.visibility = View.VISIBLE
        else
            binding.progressBar.visibility = View.GONE
    }

    private fun handleNewsResponse(response: Result<NewsResponse>) {
        when (response) {
            is Result.Success -> {
                updateTrending(response.data?.articles?.get(0))
            }

            is Result.Error -> {
                activity?.showToast("${response.message}")
            }
        }
    }

    @SuppressLint("SetTextI18n")
    private fun updateTrending(trendingArticles: Articles?) {
        trendingArticles ?: return
        binding.apply {
            context?.loadImage(trendingIv, trendingArticles.urlToImage)
            trendingSourceNameTv.text =
                trendingArticles.source?.name ?: getString(R.string.not_avail)
            trendingAuthorNameTv.text = trendingArticles.author ?: getString(R.string.not_avail)
            trendingTitleTv.text = trendingArticles.title ?: getString(R.string.not_avail)
            trendingTimeStampTv.text = trendingArticles.publishedAt.hourAgoFormat()
            dateTimeTv.text = "Today, ${currentTime()}"
        }

    }
}