package com.example.newsappassignment.app.utils

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.view.View
import android.widget.ImageView
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.lifecycle.LiveData
import androidx.navigation.fragment.findNavController
import com.bumptech.glide.Glide

fun <R> FragmentActivity.observe(liveData: LiveData<R>, observer: (e: R) -> Unit) {
    liveData.observe(
        this
    ) { value ->
        value?.let { observer(it) }
    }
}

fun <R> Fragment.observe(liveData: LiveData<R>, observer: (e: R) -> Unit) {
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

inline fun <reified T> Context.handleIntent(): Intent {
    return Intent(this, T::class.java)
}

fun Fragment.navigateToNext(actionId: Int) {
    findNavController().navigate(actionId)
}

fun Fragment.pop() {
    findNavController().popBackStack()
}

inline fun <reified T> Activity.moveToActivity() {
    val intent = Intent(this, T::class.java)
    startActivity(intent)
}

/**
 * Show the view  (visibility = View.VISIBLE)
 */
fun View.show(): View {
    if (visibility != View.VISIBLE)
        visibility = View.VISIBLE
    return this
}

/**
 * Show the view if [predicate] returns true
 * (visibility = View.VISIBLE)
 */
inline fun View.showIf(predicate: () -> Boolean): View {
    if (visibility != View.VISIBLE && predicate())
        visibility = View.VISIBLE
    return this
}

/**
 * Remove the view (visibility = View.GONE)
 */
fun View.gone(): View {
    if (visibility != View.GONE)
        visibility = View.GONE
    return this
}

/**
 * Remove the view if [predicate] returns true
 * (visibility = View.GONE)
 */
inline fun View.hideIf(predicate: () -> Boolean): View {
    if (visibility != View.GONE && predicate())
        visibility = View.GONE
    return this
}