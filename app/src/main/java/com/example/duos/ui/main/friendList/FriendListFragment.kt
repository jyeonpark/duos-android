package com.example.duos.ui.main.friendList

import android.util.Log
import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.example.duos.databinding.FragmentFriendListBinding
import com.example.duos.ui.BaseFragment
import com.google.android.material.tabs.TabLayoutMediator

class FriendListFragment(): BaseFragment<FragmentFriendListBinding>(FragmentFriendListBinding::inflate) {

    override fun initAfterBinding() {
        val friendCount : Int = 20 // 서버에서 친구 수 받아오기
        val tabText = arrayListOf("찜한 친구($friendCount)", "지난 추천 친구")

        val friendListViewpagerAdapter = FriendListViewpagerAdapter(this)
        binding.friendListContentVp.adapter = friendListViewpagerAdapter

        val child = binding.friendListContentVp.getChildAt(0)
        (child as RecyclerView)?.overScrollMode = View.OVER_SCROLL_NEVER

        TabLayoutMediator(binding.friendListContentTb, binding.friendListContentVp){
            tab, position -> tab.text = tabText[position]
        }.attach()
    }

    companion object {
        fun newInstance(): FriendListFragment = FriendListFragment()
    }
}