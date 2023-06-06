package com.example.newsappassignment.app.ui.splash

import com.example.newsappassignment.app.base.BaseViewModel
import com.example.newsappassignment.app.utils.KEY_SKIP_INTRO
import com.example.newsappassignment.data.repoimpl.PrefRepoImpl
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class SplashViewModel @Inject constructor(
    private val pref: PrefRepoImpl
) : BaseViewModel() {

    suspend fun isSkipOnboard() = pref.getSkipOnboard(KEY_SKIP_INTRO) ?: false
}