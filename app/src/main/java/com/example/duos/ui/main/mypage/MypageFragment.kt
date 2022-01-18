package com.example.duos.ui.main.mypage

import android.content.Intent
import com.example.duos.databinding.FragmentMypageBinding
import com.example.duos.ui.BaseFragment
import com.example.duos.ui.main.mypage.customerservice.CustomerServiceActivity
import com.example.duos.ui.main.mypage.lastpromise.PreviousGameActivity
import com.example.duos.ui.main.mypage.myprofile.MyProfileActivity
import com.example.duos.ui.main.mypage.notion.NotionActivity
import com.example.duos.ui.main.mypage.setup.SetupActivity

class MypageFragment() : BaseFragment<FragmentMypageBinding>(FragmentMypageBinding::inflate) {

    override fun initAfterBinding() {

//        나의 프로필 클릭 리스너
        binding.myProfileHomeConstraintLayoutCl.setOnClickListener {
            val intent = Intent(activity, MyProfileActivity::class.java)
            startActivity(intent)
        }

//        지난 약속 클릭 리스너
        binding.myPageLastAppointmentTextTv.setOnClickListener {
            val intent = Intent(activity, PreviousGameActivity::class.java)
            startActivity(intent)
        }

//        공지 사항 클릭 리스너
        binding.myPageNoticeTextTv.setOnClickListener {
            val intent = Intent(activity, NotionActivity::class.java)
            startActivity(intent)
        }

//        고객 센터 클릭 리스너
        binding.myPageCustomerServiceCenterTextTv.setOnClickListener {
            val intent = Intent(activity, CustomerServiceActivity::class.java)
            startActivity(intent)
        }

//       설정 클릭 리스너
        binding.myPageSetTextTv.setOnClickListener {
            val intent = Intent(activity, SetupActivity::class.java)
            startActivity(intent)
        }


    }

}