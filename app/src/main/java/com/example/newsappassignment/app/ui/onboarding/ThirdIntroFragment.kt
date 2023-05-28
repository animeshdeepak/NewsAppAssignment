package com.example.newsappassignment.app.ui.onboarding

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.newsappassignment.app.base.BaseFragment
import com.example.newsappassignment.databinding.FragmentThirdIntroBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class ThirdIntroFragment : BaseFragment() {
    private lateinit var binding: FragmentThirdIntroBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentThirdIntroBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initUI()
    }

    private fun initUI() {
        binding.apply {
            skipBtn.setOnClickListener {
                moveToHome()
            }
            finishBtn.setOnClickListener {
                moveToHome()
            }
        }
    }

    companion object {
        fun getInstance(): ThirdIntroFragment {
            return ThirdIntroFragment()
        }
    }
}