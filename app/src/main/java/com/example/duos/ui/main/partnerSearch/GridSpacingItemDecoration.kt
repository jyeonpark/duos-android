package com.example.duos.ui.main.partnerSearch

import android.graphics.Rect
import android.util.TypedValue
import android.view.View
import androidx.recyclerview.widget.RecyclerView

class GridSpacingItemDecoration(private val marginStart: Int, private val marginTop: Int, private val marginBottom: Int): RecyclerView.ItemDecoration() {
    override fun getItemOffsets(
        outRect: Rect,
        view: View,
        parent: RecyclerView,
        state: RecyclerView.State
    ) {
        super.getItemOffsets(outRect, view, parent, state)

        val position = parent.getChildAdapterPosition(view)
        val count = state.itemCount

        if(position % 2 != 0){  // 짝수번째 item에 marginStart 16
            outRect.left = 18   // 18대신 marginStart여야하는데.. 일단 임시로 대충 정렬맞춰지는 18로
        }
        if(position >= 2){  // 첫째줄 빼고 marginTop 20
            outRect.top = marginTop
            if(position >= count - 2){  //마지막줄은 marginBottom 16
                outRect.bottom = marginBottom
            }
        }
    }
}