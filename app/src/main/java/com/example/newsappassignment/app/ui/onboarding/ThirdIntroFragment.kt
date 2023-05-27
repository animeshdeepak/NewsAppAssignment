package com.example.newsappassignment.app.ui.onboarding

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.newsappassignment.R
import com.example.newsappassignment.app.utils.navigateToNext
import com.example.newsappassignment.databinding.FragmentThirdIntroBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class ThirdIntroFragment : Fragment() {
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
        binding.finishBtn.setOnClickListener {
            navigateToNext(R.id.action_global_homeActivity)
            activity?.finish()
        }
    }

    companion object {
        fun getInstance(): ThirdIntroFragment {
            return ThirdIntroFragment()
        }
    }
}