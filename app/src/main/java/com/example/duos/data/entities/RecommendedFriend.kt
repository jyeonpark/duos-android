package com.example.duos.data.entities

import com.google.gson.annotations.SerializedName

data class RecommendedFriend(
    @SerializedName("nickname") var recommendedFriendNickname: String = "",
    @SerializedName("age") var recommendedFriendAge: Int? = null,
    @SerializedName("gender") var recommendedFriendGender: Int? = null,
    @SerializedName("profileImageUrl") var recommendedFriendImgUrl: String? = "",
    @SerializedName("isStarred") var recommendedFriendIsStarred : Boolean = false // 찜한 여부
)
