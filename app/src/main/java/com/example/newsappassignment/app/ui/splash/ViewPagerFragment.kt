package com.example.newsappassignment.app.ui.splash

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.newsappassignment.app.base.BaseFragment
import com.example.newsappassignment.app.ui.onboarding.FirstIntroFragment
import com.example.newsappassignment.app.ui.onboarding.SecondIntroFragment
import com.example.newsappassignment.app.ui.onboarding.ThirdIntroFragment
import com.example.newsappassignment.databinding.FragmentViewPagerBinding

class ViewPagerFragment : BaseFragment() {
    private lateinit var binding: FragmentViewPagerBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentViewPagerBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setUpViewPager()
    }

    private fun setUpViewPager() {
        val fragmentList = arrayListOf(
            FirstIntroFragment.getInstance(),
            SecondIntroFragment.getInstance(),
            ThirdIntroFragment.getInstance()
        )

        ViewPagerAdapter(
            requireActivity().supportFragmentManager,
            lifecycle,
            fragmentList
        ).also {
            binding.viewpager.adapter = it
        }
    }
}