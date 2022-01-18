package com.example.duos.ui.main

import android.app.Dialog
import android.content.Context
import android.view.WindowManager
import android.widget.Button
import android.widget.TextView
import com.example.duos.R


class MyDialog(context: Context) {
    private val dialog = Dialog(context)
    private lateinit var onClickListener: OnDialogClickListener

    fun setOnClickListener(listener: OnDialogClickListener)
    {
        onClickListener = listener
    }

    fun showDialog()
    {
        dialog.setContentView(R.layout.custom_dialog)
        dialog.window!!.setLayout(WindowManager.LayoutParams.WRAP_CONTENT, WindowManager.LayoutParams.WRAP_CONTENT)
        dialog.setCanceledOnTouchOutside(true)
        dialog.setCancelable(true)
        dialog.show()

        val edit_name = dialog.findViewById<TextView>(R.id.messageTextView)

        // 취소
        dialog.findViewById<Button>(R.id.leftButton).setOnClickListener {
            dialog.dismiss()
        }

        // 탈퇴
        dialog.findViewById<Button>(R.id.rightButton).setOnClickListener {
            dialog.dismiss()
            //TODO : 회원 탈퇴했으므로 그에 대한 이벤트 처리와 첫 화면을 이동(소개페이지?)
        }

    }

    interface OnDialogClickListener
    {
        fun onClicked(name: String)
    }

}