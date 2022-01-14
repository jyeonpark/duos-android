package com.example.duos.ui.main.mypage.setup

import com.example.duos.ui.BaseActivity
import com.example.duos.ui.main.mypage.setup.SetupActivity
import com.example.duos.databinding.ActivitySetupBinding
import com.example.duos.R

class SetupActivity : BaseActivity<ActivitySetupBinding>(ActivitySetupBinding::inflate) {


    override fun initAfterBinding() {

        supportFragmentManager.beginTransaction()
            .replace(R.id.setup_into_fragment_container_fc, SetupFragment())
            .commitAllowingStateLoss()
    }

}

