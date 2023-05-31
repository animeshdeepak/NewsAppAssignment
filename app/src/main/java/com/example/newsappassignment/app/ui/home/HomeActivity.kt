package com.example.newsappassignment.app.ui.home

import android.os.Bundle
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.setupWithNavController
import com.example.newsappassignment.R
import com.example.newsappassignment.app.base.BaseActivity
import com.example.newsappassignment.databinding.ActivityMainBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class HomeActivity : BaseActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initUI()
    }

    private fun initUI() {
        setUpNavigation()
    }

    private fun setUpNavigation() {
        val navHostFragment =
            supportFragmentManager.findFragmentById(R.id.nav_host_fragment) as NavHostFragment
        val navController = navHostFragment.navController
//        val navView: BottomNavigationView = findViewById(R.id.bottomNavigation)
        binding.bottomNavigation.setupWithNavController(navController)
    }
}