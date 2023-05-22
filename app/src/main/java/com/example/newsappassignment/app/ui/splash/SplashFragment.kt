package com.example.newsappassignment.app.ui.splash

import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.newsappassignment.app.ui.home.HomeActivity
import com.example.newsappassignment.app.utils.SPLASH_LOADING_TIME
import com.example.newsappassignment.app.utils.handleIntent
import com.example.newsappassignment.databinding.FragmentSplashBinding


class SplashFragment : Fragment() {
    private lateinit var binding: FragmentSplashBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentSplashBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        Handler(Looper.getMainLooper()).postDelayed({
            val intent = context?.handleIntent<HomeActivity>()
            startActivity(intent)
            activity?.finish()
        }, SPLASH_LOADING_TIME)
    }
}