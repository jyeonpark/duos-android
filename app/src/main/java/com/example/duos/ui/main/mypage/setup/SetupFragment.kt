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
import com.example.duos.ui.main.CustomDialog


class SetupFragment : Fragment() {

    private var _binding: FragmentSetupBinding? = null
    private val binding get() = _binding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val resignBuilder = CustomDialog.Builder(requireContext())
            .setCommentMessage("회원탈퇴시 기존 데이터는 복구할 수 없습니다.\n 회원 탈퇴 하시겠습니까?")
            .setRightButton("탈퇴", object : CustomDialog.CustomDialogCallback {
                override fun onClick(dialog: CustomDialog, message: String) {
                    //TODO: ("Not yet implemented") API 호출
                    dialog.dismiss()
                }
            })
            .setLeftButton("취소", object : CustomDialog.CustomDialogCallback {
                override fun onClick(dialog: CustomDialog, message: String) {
                    // 바로 dismiss 되야야 함
                    dialog.dismiss()
                }
            })


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
            resignBuilder.show()

        }
        return binding!!.root
    }


}
