package com.example.newsappassignment.app.ui.splash

import android.os.Bundle
import androidx.activity.viewModels
import androidx.navigation.fragment.NavHostFragment
import com.example.newsappassignment.R
import com.example.newsappassignment.app.base.BaseActivity
import com.example.newsappassignment.databinding.ActivitySplashBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class SplashActivity : BaseActivity() {
    private lateinit var binding: ActivitySplashBinding
    private val viewModel: SplashViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySplashBinding.inflate(layoutInflater)
        setContentView(binding.root)

        initUI()
        initObserve()
    }

    private fun initUI() {
        setUpNavigationGraph()
    }

    private fun initObserve() = Unit

    private fun setUpNavigationGraph() {
        val navHostFragment =
            supportFragmentManager.findFragmentById(R.id.nav_host_fragment) as NavHostFragment
        val navController = navHostFragment.navController
    }
}