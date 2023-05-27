package com.example.newsappassignment.app.ui.onboarding

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.viewpager2.widget.ViewPager2
import com.example.newsappassignment.R
import com.example.newsappassignment.app.utils.navigateToNext
import com.example.newsappassignment.databinding.FragmentSecondIntroBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class SecondIntroFragment : Fragment() {
    private lateinit var binding: FragmentSecondIntroBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentSecondIntroBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initUI()
    }

    private fun initUI() {
        binding.nextBtn.setOnClickListener {
            activity?.findViewById<ViewPager2>(R.id.viewpager)?.currentItem = 2
        }
    }

    companion object {
        fun getInstance(): SecondIntroFragment {
            return  SecondIntroFragment()
        }
    }
}