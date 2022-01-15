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




    }
}