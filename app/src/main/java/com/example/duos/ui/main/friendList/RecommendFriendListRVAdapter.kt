package com.example.duos.ui.main.friendList

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.duos.data.entities.RecommendedFriend
import com.example.duos.databinding.ItemFragmentRecommendFriendListBinding

class RecommendFriendListRVAdapter (private val friendlist : ArrayList<RecommendedFriend>) : RecyclerView.Adapter<RecommendFriendListRVAdapter.ViewHolder>() {

    // 클릭 인터페이스 정의
    interface MyItemClickListener{
        fun onDeleteFriend(friendId : String)
        fun onAddFriend(friendId: String)
        fun onDeleteText()
    }

    // 리스너 객체를 전달받는 함수랑 리스너 객체를 저장할 변수
    private lateinit var mItemClickListener: MyItemClickListener


    fun setMyItemClickListener(itemClickListener: MyItemClickListener){
        mItemClickListener = itemClickListener
    }

    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): RecommendFriendListRVAdapter.ViewHolder {
        val binding: ItemFragmentRecommendFriendListBinding = ItemFragmentRecommendFriendListBinding.inflate(
            LayoutInflater.from(viewGroup.context), viewGroup, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(friendlist[position], position)

        // 친구 삭제 버튼 클릭시 삭제
        holder.binding.recommendFriendListTodayDeleteBtn.setOnClickListener {
            mItemClickListener.onDeleteFriend(friendlist[position].recommendedFriendNickname)
            removeFriend(position)
        }

    }

    private fun removeFriend(position: Int) {
        friendlist.removeAt(position)
        notifyItemRemoved(position)
        notifyItemRangeChanged(position, friendlist.size)
        if (friendlist.size == 0){
            mItemClickListener.onDeleteText()
        }
    }

    @SuppressLint("NotifyDataSetChanged")
    fun addFriend(friends: ArrayList<RecommendedFriend>) {
        this.friendlist.clear()
        this.friendlist.addAll(friends)

        notifyDataSetChanged()
    }

    override fun getItemCount(): Int = friendlist.size



    // 뷰홀더
    inner class ViewHolder(val binding: ItemFragmentRecommendFriendListBinding): RecyclerView.ViewHolder(binding.root){
        fun bind(friend : RecommendedFriend, position: Int){
            binding.recommendFriendListTodayIdTv.text = friend.recommendedFriendNickname
            binding.recommendFriendListTodayAgeTv.text = friend.recommendedFriendAge.toString()
            binding.recommendFriendListTodaySexTv.text =
                when(friend.recommendedFriendGender) {
                    1-> "남자"
                    else -> "여자"
                }
            Glide.with(binding.recommendFriendListTodayProfileImageIv.context)
                .load(friend.recommendedFriendImgUrl)
                .into(binding.recommendFriendListTodayProfileImageIv)
        }
    }
}