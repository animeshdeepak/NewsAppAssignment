package com.example.newsappassignment.app.ui.explore

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.newsappassignment.app.base.BaseFragment
import com.example.newsappassignment.databinding.FragmentExploreBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class ExploreFragment : BaseFragment() {
    private lateinit var binding: FragmentExploreBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        binding = FragmentExploreBinding.inflate(inflater, container, false)
        return binding.root
    }

    companion object {
        fun newInstance(param1: String, param2: String) =
            ExploreFragment().apply {
                arguments = Bundle().apply {
//                    putString(ARG_PARAM1, param1)
//                    putString(ARG_PARAM2, param2)
                }
            }
    }
}