package com.example.newsappassignment.app.ui.onboarding

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.viewpager2.widget.ViewPager2
import com.example.newsappassignment.R
import com.example.newsappassignment.app.utils.navigateToNext
import com.example.newsappassignment.databinding.FragmentFirstIntroBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class FirstIntroFragment : Fragment() {
    private lateinit var binding: FragmentFirstIntroBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentFirstIntroBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initUI()
    }

    private fun initUI() {
        binding.nextBtn.setOnClickListener {
            activity?.findViewById<ViewPager2>(R.id.viewpager)?.currentItem = 1
        }
    }

    companion object {
        fun getInstance(): FirstIntroFragment {
            return FirstIntroFragment()
        }
    }
}