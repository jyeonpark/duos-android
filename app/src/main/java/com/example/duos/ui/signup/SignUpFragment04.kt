package com.example.duos.ui.signup

import android.graphics.Color
import android.util.Log
import android.widget.RadioButton
import androidx.core.content.ContextCompat
import com.example.duos.R
import com.example.duos.databinding.FragmentSignup04Binding
import com.example.duos.ui.BaseFragment

class SignUpFragment04() : BaseFragment<FragmentSignup04Binding>(FragmentSignup04Binding::inflate) {
    override fun initAfterBinding() {

        for (i in 1 .. 14){
            var btnId : Int = resources.getIdentifier("signup_04_radio_" + i.toString() + "_btn", "id",requireActivity().packageName)
            // var radioButton : RadioButton = requireView().findViewById(btnId)
            // val num : String = i.toString()
            // radioButton.text = resources.getString(resources.getIdentifier("signup_length_of_play_$num", "string", requireActivity().packageName))
        }

        binding.signup04RadioGroupRg.setOnCheckedChangeListener { radioGroup, i ->
            Log.d("선택",i.toString() )
            requireView().findViewById<RadioButton>(i).background = ContextCompat.getDrawable(requireContext(),R.drawable.signup_sex_select_rectangular)
        }

    }
}