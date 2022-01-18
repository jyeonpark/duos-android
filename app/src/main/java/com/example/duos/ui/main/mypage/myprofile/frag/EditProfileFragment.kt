package com.example.duos.ui.main.mypage.myprofile.frag

import android.os.Bundle
import android.text.InputType
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
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
//
//        binding.nicknameEt.setInputType(InputType.TYPE_TEXT_FLAG_NO_SUGGESTIONS)
//        binding.nicknameEt.setInputType(InputType.TYPE_TEXT_FLAG_NO_SUGGESTIONS)
//        binding.locationInfoEt.setInputType(InputType.TYPE_TEXT_FLAG_NO_SUGGESTIONS)


        return binding.root
    }

}