package com.example.duos.ui.main.mypage.customerservice

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.duos.data.entities.MyProfileReview
import com.example.duos.databinding.FragmentCsMenuBinding

class CsMenuFragment :Fragment () {

    private var _binding : FragmentCsMenuBinding? =null
    private val binding get() = _binding
    private var reviewDatas = ArrayList<MyProfileReview>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentCsMenuBinding.inflate(inflater,container,false)




        return binding!!.root
    }

}
