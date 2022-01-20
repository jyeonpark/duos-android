package com.example.duos.ui.main.mypage.myprofile.frag

import android.widget.Button
import com.example.duos.databinding.FragmentEditProfileBinding
import com.example.duos.ui.BaseFragment

class EditProfileFragment : BaseFragment<FragmentEditProfileBinding>(FragmentEditProfileBinding::inflate) {

    override fun initAfterBinding() {


        for (i in 1..14) {
            var btnId: Int = resources.getIdentifier("edit_profile_table_" + i.toString() + "_btn", "id", requireActivity().packageName)

            var btn: Button = requireView().findViewById(btnId)
            val num: String = i.toString()

            btn.text = resources.getString(resources.getIdentifier("signup_length_of_play_$num", "string", requireActivity().packageName))

        }
    }

}