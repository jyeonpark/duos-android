package com.example.duos.ui.main.mypage.customerservice

import com.example.duos.R
import com.example.duos.databinding.ActivityCustomerServiceBinding
import com.example.duos.ui.BaseActivity

class CustomerServiceActivity :
    BaseActivity<ActivityCustomerServiceBinding>(ActivityCustomerServiceBinding::inflate) {

    override fun initAfterBinding() {

        supportFragmentManager.beginTransaction()
            .replace(R.id.customer_service_into_fragment_container_fc, CsMenuFragment())
            .commitAllowingStateLoss()


    }


}