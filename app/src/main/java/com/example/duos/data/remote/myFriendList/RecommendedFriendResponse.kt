package com.example.duos.data.remote.myFriendList

import com.example.duos.data.entities.RecommendedFriend
import com.google.gson.annotations.SerializedName

data class RecommendedFriendListOnDate(@SerializedName("recommendedAt") val recommendedDate: String,
                                       @SerializedName("recommendPartnerDummyDtoList") val recommendedFriendList : List<RecommendedFriend>)

data class RecommendedFriendResponse(
    @SerializedName("isSuccess") val isSuccess: Boolean,
    @SerializedName("code") val code: Int,
    @SerializedName("message") val message: String,
    @SerializedName("result") val result: List<com.example.duos.data.remote.myFriendList.RecommendedFriendListOnDate>?
)
