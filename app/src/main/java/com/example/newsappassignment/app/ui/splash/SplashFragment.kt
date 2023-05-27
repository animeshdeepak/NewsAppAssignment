package com.example.newsappassignment.app.ui.splash

import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.newsappassignment.R
import com.example.newsappassignment.app.utils.SPLASH_LOADING_TIME
import com.example.newsappassignment.app.utils.navigateToNext
import com.example.newsappassignment.databinding.FragmentSplashBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class SplashFragment : Fragment() {
    private lateinit var binding: FragmentSplashBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentSplashBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        moveToOnBoardFragment()
    }

    private fun moveToOnBoardFragment() {
        Handler(Looper.getMainLooper()).postDelayed({
            navigateToNext(R.id.action_splashFragment_to_viewPagerFragment)
        }, SPLASH_LOADING_TIME)
    }
}