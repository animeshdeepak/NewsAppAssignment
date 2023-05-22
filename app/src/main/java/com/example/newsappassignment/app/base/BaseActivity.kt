package com.example.newsappassignment.app.base

import androidx.appcompat.app.AppCompatActivity

abstract class BaseActivity : AppCompatActivity() {
    abstract fun initUI()
    abstract fun initObserve()
}