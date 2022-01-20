package com.example.duos.ui.signup


import android.content.Context
import android.os.Bundle
import android.util.Log
import android.view.*
import android.widget.Button
import android.widget.NumberPicker
import android.widget.RadioButton
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.example.duos.R
import com.example.duos.ToggleButtonGroupTableLayout
import com.example.duos.databinding.FragmentSignup02Binding


class SignUpFragment02() : Fragment() {

    lateinit var binding: FragmentSignup02Binding
    lateinit var nextBtnListener: SignUpNextBtnInterface
    lateinit var mContext: SignUpActivity
    var savedState: Bundle? = null
    var birthTextView: TextView? = null
    lateinit var npYear: NumberPicker
    lateinit var npMonth: NumberPicker
    lateinit var npDay: NumberPicker

    override fun onAttach(context: Context) {
        super.onAttach(context)
        if (context is SignUpActivity) {
            mContext = context
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentSignup02Binding.inflate(inflater, container, false)
        requireActivity().findViewById<TextView>(R.id.signup_process_tv).text = "02"
        nextBtnListener = mContext

        binding.signup02BirthEt.setOnClickListener {
            nextBtnListener.onNextBtnChanged(true)
            BirthNumberPicker()
        }

        birthTextView = binding.signup02BirthEt
        if (savedInstanceState != null && savedState == null) {
            savedState = savedInstanceState.getBundle("savedState")
        }
        if (savedState != null) {
            birthTextView!!.setText(savedState!!.getCharSequence("birth"));
        }
        savedState = null;

        return binding.root
    }


    override fun onDestroyView() {
        super.onDestroyView()
        savedState = saveState() /* vstup defined here for sure */
        birthTextView = null
    }

    private fun saveState(): Bundle { /* called either from onDestroyView() or onSaveInstanceState() */
        val state = Bundle()
        if (birthTextView?.text != null)
            state.putCharSequence("birth", birthTextView!!.getText()!!)

        return state
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putBundle(
            "savedState",
            if (savedState != null) savedState else saveState()
        )
    }

    private fun BirthNumberPicker() {

        binding.signup02NumberPickerLinearLayoutLl.visibility = View.VISIBLE

        npYear = binding.signupNumberPickerYear
        npMonth = binding.signupNumberPickerMonth
        npDay = binding.signupNumberPickerDay

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
    }

    fun setBirth(){
        binding.signup02BirthEt.text = ((2022 - npYear.value + 1).toString() + "년 " + npMonth.value.toString() + "월 " + npDay.value.toString() + " 일 ")
        binding.signup02NumberPickerLinearLayoutLl.visibility = View.GONE
    }


}