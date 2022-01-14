package com.example.duos.ui.main.mypage.notion

import com.example.duos.ui.BaseActivity
import com.example.duos.ui.main.mypage.notion.NotionActivity
import com.example.duos.databinding.ActivityNotionBinding
import com.example.duos.R

class NotionActivity : BaseActivity<ActivityNotionBinding>(ActivityNotionBinding::inflate) {


    override fun initAfterBinding() {

        supportFragmentManager.beginTransaction()
            .replace(R.id.notion_into_fragment_container_fc, NotionFragment())
            .commitAllowingStateLoss()
    }

}

