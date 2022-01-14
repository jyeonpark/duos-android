package com.example.duos.ui.main.mypage

import android.content.Intent
import com.example.duos.databinding.FragmentMypageBinding
import com.example.duos.ui.BaseFragment
import com.example.duos.ui.main.mypage.myprofile.MyProfileActivity

class MypageFragment() : BaseFragment<FragmentMypageBinding>(FragmentMypageBinding::inflate) {

    override fun initAfterBinding() {
        binding.myPageTv.setOnClickListener {
            val intent = Intent(activity, MyProfileActivity::class.java)
            startActivity(intent)
        }
    }

    companion object {
        fun newInstance(): MypageFragment = MypageFragment()
    }
}