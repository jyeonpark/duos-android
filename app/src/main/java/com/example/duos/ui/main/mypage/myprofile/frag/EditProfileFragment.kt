package com.example.duos.ui.main.mypage.myprofile.frag

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.activity.addCallback
import androidx.navigation.fragment.findNavController
import com.example.duos.R
import com.example.duos.databinding.FragmentEditProfileBinding

class EditProfileFragment : Fragment() {
    private var _binding : FragmentEditProfileBinding ? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentEditProfileBinding.inflate(inflater, container, false)





        return binding.root
    }

}