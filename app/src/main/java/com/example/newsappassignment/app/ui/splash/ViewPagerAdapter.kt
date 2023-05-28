package com.example.newsappassignment.app.ui.splash

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.Lifecycle
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.newsappassignment.app.base.BaseFragment

class ViewPagerAdapter(
    fragmentManager: FragmentManager,
    lifecycle: Lifecycle,
    private val fragmentList: ArrayList<BaseFragment>
) : FragmentStateAdapter(fragmentManager, lifecycle) {

    override fun getItemCount() = fragmentList.size

    override fun createFragment(position: Int): Fragment = fragmentList[position]
}