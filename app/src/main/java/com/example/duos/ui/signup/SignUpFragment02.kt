package com.example.duos.ui.signup


import android.view.*
import android.widget.NumberPicker
import com.example.duos.databinding.FragmentSignup02Binding
import com.example.duos.ui.BaseFragment


class SignUpFragment02() : BaseFragment<FragmentSignup02Binding>(FragmentSignup02Binding::inflate) {

    override fun initAfterBinding() {

        binding.signup02BirthEt.setOnClickListener {
            BirthNumberPicker()
        }

    }

    private fun BirthNumberPicker(){

        binding.signup02NpLinearLayoutLl.visibility = View.VISIBLE

        val npYear : NumberPicker = binding.signupNumberPickerYear
        val npMonth : NumberPicker = binding.signupNumberPickerMonth
        val npDay : NumberPicker = binding.signupNumberPickerDay

        var yearList = ArrayList<String>()
        var monthList = ArrayList<String>()
        var dateList = ArrayList<String>()

        for (i: Int in 2022 downTo 1922)
            yearList.add(i.toString() + "년")

        for (i: Int in 1..12)
            monthList.add(i.toString() + "월")

        for (i: Int in 1..31)
            dateList.add(i.toString() + "일")

        npYear.run {
            minValue = 1
            maxValue = 100
            wrapSelectorWheel = false
            value = 1
            displayedValues = yearList.toTypedArray()
        }
        npMonth.run {
            minValue = 1
            maxValue = 12
            wrapSelectorWheel = false
            value = 1
            displayedValues = monthList.toTypedArray()

        }
        npDay.run {
            minValue = 1
            maxValue = 31
            wrapSelectorWheel = false
            value = 1
            displayedValues = dateList.toTypedArray()
        }

        binding.signup02RootConstraintLayoutCl.setOnClickListener {
            binding.signup02BirthEt.text = ((2022 - npYear.value + 1).toString()  + "년 " +
                    npMonth.value.toString() + "월 " + npDay.value.toString() + " 일 ")
            binding.signup02NpLinearLayoutLl.visibility = View.GONE
        }
    }


}