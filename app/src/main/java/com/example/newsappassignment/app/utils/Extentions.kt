package com.example.newsappassignment.app.utils

import android.content.Context
import android.content.Intent
import android.widget.ImageView
import android.widget.Toast
import androidx.fragment.app.FragmentActivity
import androidx.lifecycle.LiveData
import com.bumptech.glide.Glide
import java.text.SimpleDateFormat
import java.util.Locale

fun <R> FragmentActivity.observe(liveData: LiveData<R>, observer: (e: R) -> Unit) {
    liveData.observe(
        this
    ) { value ->
        value?.let { observer(it) }
    }
}

fun Context.loadImage(imageView: ImageView, url: String?) {
    Glide.with(this)
        .load(url)
        .into(imageView)
}

fun Context.showToast(message: String) {
    Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
}

fun String?.changeDateFormat(): String {
    if (this.isNullOrEmpty()) {
        return ""
    }
    return try {
        val sourceSdf = SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss", Locale.getDefault())
        val requiredSdf = SimpleDateFormat("dd.MM.yyyy HH:mm:ss", Locale.getDefault())
        requiredSdf.format(sourceSdf.parse(this)!!)
    } catch (ex: Exception) {
        ""
    }
}

inline fun <reified T> Context.handleIntent(): Intent {
    return Intent(this, T::class.java)
}