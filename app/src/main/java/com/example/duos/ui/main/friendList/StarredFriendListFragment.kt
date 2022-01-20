package com.example.duos.ui.main.friendList

import android.util.Log
import androidx.recyclerview.widget.LinearLayoutManager

import com.example.duos.data.entities.StarredFriend
import com.example.duos.data.remote.myFriendList.FriendListService
import com.example.duos.databinding.FragmentStarredFriendListBinding
import com.example.duos.ui.BaseFragment

class StarredFriendListFragment() : BaseFragment<FragmentStarredFriendListBinding>(FragmentStarredFriendListBinding::inflate), StarredFriendListView{

    private var friendListDatas = ArrayList<StarredFriend>()

    override fun initAfterBinding() {

        binding.starredFriendListRecyclerviewRc.itemAnimator = null
        binding.starredFriendListRecyclerviewRc.layoutManager = LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
        binding.starredFriendListRecyclerviewRc.adapter = StarredFriendListRVAdapter(ArrayList<StarredFriend>())
        FriendListService.starredFriendList(this, 1)


    }

    override fun onGetStarredFriendListSuccess(starredFriendList: List<StarredFriend>) {

        friendListDatas.addAll(starredFriendList)

        val starredFriendListRVAdapter = StarredFriendListRVAdapter(friendListDatas)

        starredFriendListRVAdapter.setMyItemClickListener(object : StarredFriendListRVAdapter.MyItemClickListener{
            override fun onDeleteFriend(friendId: String) {
                // 찜한친구 목록에서 삭제
            }
        })
        binding.starredFriendListRecyclerviewRc.adapter = starredFriendListRVAdapter
    }

    override fun onGetStarredFriendListFailure(code: Int, message: String) {
        showToast("code : $code, message : $message")
    }
}