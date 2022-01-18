package com.example.duos.ui.main.mypage.setup

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.CompoundButton
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import com.example.duos.R
import com.example.duos.databinding.FragmentSetupBinding
import com.example.duos.ui.main.MyDialog


class SetupFragment : Fragment() {

    private var _binding: FragmentSetupBinding? = null
    private val binding get() = _binding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentSetupBinding.inflate(inflater, container, false)

//        알림 설정 스위치
        _binding!!.notificationSettingSw.setOnCheckedChangeListener { compoundButton: CompoundButton, isChecked: Boolean ->
            if (isChecked) {
                _binding!!.noticeOnoffTv.text = "켜짐"
                _binding!!.noticeOnoffTv.setTextColor(
                    ContextCompat.getColor(
                        requireContext(),
                        R.color.primary
                    )
                )
                //Todo : 알림을 받도록
            } else {
                _binding!!.noticeOnoffTv.text = "꺼짐"
                _binding!!.noticeOnoffTv.setTextColor(
                    ContextCompat.getColor(
                        requireContext(),
                        R.color.grey
                    )
                )
                //Todo : 알림을 받지 않도록
            }
        }

        _binding!!.btnDeleteAccountCl.setOnClickListener {
            val dialog = MyDialog(requireContext())
            dialog.showDialog()
            dialog.setOnClickListener(object:MyDialog.OnDialogClickListener{
                override fun onClicked(name: String) {
                }

            })
        }

        return binding!!.root
    }

    // btnDelete



}
