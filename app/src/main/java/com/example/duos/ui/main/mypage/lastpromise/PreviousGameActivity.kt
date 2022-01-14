package com.example.duos.ui.main.mypage.lastpromise

import com.example.duos.R
import com.example.duos.databinding.ActivityPreviousGameBinding
import com.example.duos.ui.BaseActivity

class PreviousGameActivity :
    BaseActivity<ActivityPreviousGameBinding>(ActivityPreviousGameBinding::inflate) {

    override fun initAfterBinding() {

        supportFragmentManager.beginTransaction()
            .replace(R.id.previous_game_into_fragment_container_fc, PreviousGameFragment())
            .commitAllowingStateLoss()




//        binding.editMyProfileTv.setOnClickListener {
//            supportFragmentManager.beginTransaction()
//                .replace(R.id.my_page_into_fragment_container_fc, EditProfileFragment())
//                .commitAllowingStateLoss()
//            binding.topLeftArrowIv.setImageResource(R.drawable.ic_btn_close_iv)
//            binding.editMyProfileTv.visibility = View.GONE
//            binding.topMyProfileTv.text = "나의 프로필 수정"
//        }
    }
}