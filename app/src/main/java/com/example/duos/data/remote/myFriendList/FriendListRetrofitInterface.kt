package com.example.duos.data.remote.myFriendList

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface FriendListRetrofitInterface {
    @GET("/test/partner/starred")
    fun starredFriendList(
        @Query("userIdx") userIdx : Int
    ): Call<StarredFriendResponse>

    @GET("/test/partner/recommend/history")
    fun recommendedFriendList(
        @Query("userIdx") userIdx: Int
    ): Call<RecommendedFriendResponse>
}