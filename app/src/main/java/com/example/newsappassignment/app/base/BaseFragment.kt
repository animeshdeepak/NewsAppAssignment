package com.example.newsappassignment.app.base

import androidx.fragment.app.Fragment
import com.example.newsappassignment.R
import com.example.newsappassignment.app.utils.navigateToNext

abstract class BaseFragment : Fragment() {
    fun moveToHome() {
        navigateToNext(R.id.action_global_homeActivity)
        activity?.finish()
    }
}