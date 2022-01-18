package com.example.duos.ui.main

import android.app.Dialog
import android.content.Context
import android.os.Bundle
import android.view.Gravity
import android.view.ViewGroup
import com.example.duos.databinding.CustomDialogBinding


class CustomDialog(context: Context) : Dialog(context) {
    var messageTextView: String? = null
    var leftButtonMsg: String? = null
    var rightButtonMsg: String? = null

    var leftButtonCallback: CustomDialog.CustomDialogCallback? = null
    var rightButtonCallback: CustomDialog.CustomDialogCallback? = null

    var mBinding: CustomDialogBinding? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setCanceledOnTouchOutside(true)
        mBinding = CustomDialogBinding.inflate(layoutInflater)
        setContentView(mBinding!!.root)

//        Dialog 레이아웃 크기 및 위치 설정  setContentView 실행 후에 적용되어야 제대로 반영됨.
        window?.setGravity(Gravity.CENTER)
//        기기 가로 너비의 91% 크기로 적용하겠다
        val width = (context.resources.displayMetrics.widthPixels * 0.91).toInt()
        window?.setLayout(width, ViewGroup.LayoutParams.WRAP_CONTENT)

        initView()

    }

//    Activity 종료시 Dialog를 종료시킨다.

    override fun onDetachedFromWindow() {
        super.onDetachedFromWindow()
        this.dismiss()
    }

    //    Builder를 통해 받은 설정값들을 초기화하는 메서드
    private fun initView() {
        mBinding!!.messageTextView.setText(messageTextView)
        mBinding!!.rightButton.text = rightButtonMsg
        mBinding!!.leftButton.text = leftButtonMsg

    }

    class Builder(val context: Context) {
        private var dialog = CustomDialog(context)

        fun setCommentMessage(message: String): Builder {
            dialog.messageTextView = message
            return this
        }

        fun setRightButton(msg: String, callback: CustomDialog.CustomDialogCallback): Builder {
            dialog.rightButtonMsg = msg
            dialog.rightButtonCallback = callback
            return this
        }

        fun setLeftButton(msg: String, callback: CustomDialog.CustomDialogCallback): Builder {
            dialog.leftButtonMsg = msg
            dialog.leftButtonCallback = callback
            return this
        }

        fun show(): CustomDialog {
            dialog.show()
            return dialog
        }


    }

    interface CustomDialogCallback {
        fun onClick(dialog: CustomDialog, message: String)

//        fun dismissDialog(dialog: CustomDialog)
    }
}
