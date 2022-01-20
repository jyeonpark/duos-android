package com.example.duos.ui.main.friendList

interface RecommendedFriendListView {
    fun onGetRecommendedFriendListSuccess(starredFriendList: List<com.example.duos.data.remote.myFriendList.RecommendedFriendListOnDate>)
    fun  onGetRecommendedFriendListFailure(code: Int, message: String)
}