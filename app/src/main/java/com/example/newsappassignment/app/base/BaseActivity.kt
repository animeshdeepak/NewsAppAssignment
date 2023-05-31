package com.example.newsappassignment.app.base

import android.os.Bundle
import android.os.PersistableBundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.WindowCompat

abstract class BaseActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?, persistentState: PersistableBundle?) {
        super.onCreate(savedInstanceState, persistentState)
        hideStatusBar()
    }

    // makes sure content fits in the system window code by Philipp Lackner YT
    // in case of any issue check this out to resolve:
    // https://stackoverflow.com/questions/68451704/transparent-status-bar-with-visible-navigation-bar
    private fun hideStatusBar() {
        WindowCompat.setDecorFitsSystemWindows(
            window, false
        )
    }
}