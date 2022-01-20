package com.example.duos.ui.main.friendList

import com.example.duos.data.entities.StarredFriend

interface StarredFriendListView {
    fun onGetStarredFriendListSuccess(starredFriendList: List<StarredFriend>)
    fun  onGetStarredFriendListFailure(code: Int, message: String)
}