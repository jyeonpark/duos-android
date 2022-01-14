package com.example.duos.ui.splash

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.duos.databinding.FragmentSplashViewpager01Binding

class SplashViewpagerFragment01  : Fragment() {

    lateinit var binding : FragmentSplashViewpager01Binding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentSplashViewpager01Binding.inflate(inflater, container, false)

        return binding.root
    }
}