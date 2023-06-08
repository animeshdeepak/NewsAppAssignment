package com.example.newsappassignment.app.ui.topics

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.example.newsappassignment.app.ui.home.HomeViewModel
import com.example.newsappassignment.app.ui.topics.model.TopicDataModel
import com.example.newsappassignment.app.utils.pop
import com.example.newsappassignment.app.utils.showToast
import com.example.newsappassignment.databinding.FragmentTopicsBinding
import com.example.newsappassignment.domain.model.getFakeTopicsList
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class TopicsFragment : Fragment() {
    private val topicsList = arrayListOf<TopicDataModel>()

    private lateinit var binding: FragmentTopicsBinding
    private val viewModel: HomeViewModel by viewModels()

    private lateinit var topicsAdapter: TopicsAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentTopicsBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initUI()
    }

    private fun initUI() {
        setUpTopicsRV()
        binding.doneTv.setOnClickListener {
            pop()
        }
    }

    private fun setUpTopicsRV() {
        topicsAdapter = TopicsAdapter()
        topicsAdapter.onItemClick = { model ->
            topicsList.add(model)
            context?.showToast(model.name)
        }

        binding.topicsRv.apply {
            adapter = topicsAdapter
            setHasFixedSize(true)
        }

        topicsAdapter.submitList(getFakeTopicsList())
    }
}