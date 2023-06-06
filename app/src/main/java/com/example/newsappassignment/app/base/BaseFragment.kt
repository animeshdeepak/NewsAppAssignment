package com.example.newsappassignment.app.base

import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import com.example.newsappassignment.R
import com.example.newsappassignment.app.di.qualifiers.IODispatcher
import com.example.newsappassignment.app.utils.KEY_SKIP_INTRO
import com.example.newsappassignment.app.utils.navigateToNext
import com.example.newsappassignment.data.repoimpl.PrefRepoImpl
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.launch
import javax.inject.Inject

abstract class BaseFragment : Fragment() {
    @Inject
    lateinit var pref: PrefRepoImpl

    @Inject
    @IODispatcher
    lateinit var ioDispatcher: CoroutineDispatcher

    fun moveToHome() {
        lifecycleScope.launch(ioDispatcher) {
            pref.setSkipOnboard(KEY_SKIP_INTRO, true)
        }
        navigateToNext(R.id.action_global_homeActivity)
        activity?.finish()
    }
}