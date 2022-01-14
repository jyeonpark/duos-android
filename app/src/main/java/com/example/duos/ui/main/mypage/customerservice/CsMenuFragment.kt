package com.example.duos.ui.main.mypage.customerservice

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.duos.R
import com.example.duos.data.entities.Review
import com.example.duos.databinding.FragmentCsMenuBinding
import com.example.duos.databinding.FragmentMyProfileBinding
import com.example.duos.ui.main.mypage.myprofile.ProfileReviewRVAdapter

class CsMenuFragment :Fragment () {

    private var _binding : FragmentCsMenuBinding? =null
    private val binding get() = _binding
    private var reviewDatas = ArrayList<Review>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentCsMenuBinding.inflate(inflater,container,false)




        return binding!!.root
    }

}
