package com.example.duos.ui.main.mypage.myprofile

import android.app.Activity
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.NavController
import androidx.navigation.findNavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.fragment.findNavController
import androidx.navigation.ui.setupWithNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.duos.R
import com.example.duos.data.entities.Review
import com.example.duos.databinding.ActivityMainBinding
import com.example.duos.databinding.ActivityMyprofileBinding
import com.example.duos.ui.BaseActivity
import com.example.duos.ui.main.mypage.myprofile.frag.EditProfileFragment
import com.example.duos.ui.main.mypage.myprofile.frag.MyProfileFragment

class MyProfileActivity :
    BaseActivity<ActivityMyprofileBinding>(ActivityMyprofileBinding::inflate) {


    override fun initAfterBinding() {

        supportFragmentManager.beginTransaction()
            .replace(R.id.my_page_into_fragment_container_fc, MyProfileFragment())
            .commitAllowingStateLoss()


        binding.editMyProfileTv.setOnClickListener {
            supportFragmentManager.beginTransaction()
                .replace(R.id.my_page_into_fragment_container_fc, EditProfileFragment())
                .commitAllowingStateLoss()
            binding.topLeftArrowIv.setImageResource(R.drawable.ic_btn_close_iv)
            binding.editMyProfileTv.visibility = View.GONE
            binding.topMyProfileTv.text = "나의 프로필 수정"
        }
    }
}
