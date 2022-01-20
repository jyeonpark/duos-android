package com.example.duos.data.remote.myFriendList

import android.util.Log
import com.example.duos.ApplicationClass
import com.example.duos.ApplicationClass.Companion.TAG
import com.example.duos.ui.main.friendList.RecommendedFriendListView
import com.example.duos.ui.main.friendList.StarredFriendListView
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

object FriendListService {
    fun starredFriendList(starredFriendListView: StarredFriendListView, userIdx : Int) {
        val friendListService = ApplicationClass.retrofit.create(FriendListRetrofitInterface::class.java)

        friendListService.starredFriendList(userIdx).enqueue(object : Callback<StarredFriendResponse> {
            override fun onResponse(call: Call<StarredFriendResponse>, response: Response<StarredFriendResponse>) {
                val resp = response.body()!!
                when (resp.code) {
                    1000 ->
                        resp.result?.let { starredFriendListView.onGetStarredFriendListSuccess(it) }
                    else -> starredFriendListView.onGetStarredFriendListFailure(resp.code, resp.message)
                }
            }

            override fun onFailure(call: Call<StarredFriendResponse>, t: Throwable) {
                Log.d("$TAG/API-ERROR", t.message.toString())
                starredFriendListView.onGetStarredFriendListFailure(400, "네트워크 오류가 발생했습니다.")
            }
        })
    }

    fun recommendedFriendList(recommendedFriendListView: RecommendedFriendListView, userIdx: Int){
        val friendListService = ApplicationClass.retrofit.create(FriendListRetrofitInterface::class.java)


        friendListService.recommendedFriendList(userIdx).enqueue(object : Callback<RecommendedFriendResponse> {
            override fun onResponse(call: Call<RecommendedFriendResponse>, response: Response<RecommendedFriendResponse>) {
                val resp = response.body()!!

                when (resp.code) {
                    1000 ->
                        resp.result?.let { recommendedFriendListView.onGetRecommendedFriendListSuccess(it) }
                    else -> recommendedFriendListView.onGetRecommendedFriendListFailure(resp.code, resp.message)
                }
            }

            override fun onFailure(call: Call<RecommendedFriendResponse>, t: Throwable) {
                Log.d("$TAG/API-ERROR", t.message.toString())
                recommendedFriendListView.onGetRecommendedFriendListFailure(400, "네트워크 오류가 발생했습니다.")
            }
        })
    }
}