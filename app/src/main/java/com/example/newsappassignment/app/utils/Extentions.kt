package com.example.newsappassignment.app.utils

import androidx.fragment.app.FragmentActivity
import androidx.lifecycle.LiveData

fun <R> FragmentActivity.observe(liveData: LiveData<R>, observer: (e: R) -> Unit) {
    liveData.observe(
        this
    ) { value ->
        value?.let { observer(it) }
    }
}