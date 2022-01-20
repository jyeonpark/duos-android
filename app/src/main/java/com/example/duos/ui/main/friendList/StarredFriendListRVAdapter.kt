package com.example.duos.ui.main.friendList

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.duos.data.entities.StarredFriend
import com.example.duos.databinding.ItemFragmentStarredFriendListBinding
import com.example.duos.utils.GlideApp

class StarredFriendListRVAdapter(private val friendlist : ArrayList<StarredFriend>) : RecyclerView.Adapter<StarredFriendListRVAdapter.ViewHolder>() {


    // 클릭 인터페이스 정의
    interface MyItemClickListener{
        fun onDeleteFriend(friendId : String)
    }

    // 리스너 객체를 전달받는 함수랑 리스너 객체를 저장할 변수
    private lateinit var mItemClickListener: MyItemClickListener

    fun setMyItemClickListener(itemClickListener: MyItemClickListener){
        mItemClickListener = itemClickListener
    }

    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): StarredFriendListRVAdapter.ViewHolder {
        val binding: ItemFragmentStarredFriendListBinding = ItemFragmentStarredFriendListBinding.inflate(
            LayoutInflater.from(viewGroup.context), viewGroup, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(friendlist[position], position)

        // 친구 삭제 버튼 클릭시 삭제
        holder.binding.myFriendListDeleteBtn.setOnClickListener {
            mItemClickListener.onDeleteFriend(friendlist[position].starredFriendNickname)
            removeFriend(position)
        }

    }

    private fun removeFriend(position: Int) {
        friendlist.removeAt(position)
        notifyItemRemoved(position)
        notifyItemRangeChanged(position, friendlist.size)
    }

    @SuppressLint("NotifyDataSetChanged")
    fun addFriend(myFriends: ArrayList<StarredFriend>) {
        this.friendlist.clear()
        this.friendlist.addAll(myFriends)

        notifyDataSetChanged()
    }

    override fun getItemCount(): Int = friendlist.size
    
    

    // 뷰홀더
    inner class ViewHolder(val binding: ItemFragmentStarredFriendListBinding): RecyclerView.ViewHolder(binding.root){
        fun bind(myFriend : StarredFriend, position: Int){
            binding.myFriendListProfileIdTv.text = myFriend.starredFriendNickname
            binding.myFriendListAgeTv.text = (myFriend.starredFriendAge?.minus(myFriend.starredFriendAge!! % 10)).toString()
            binding.myFriendListSexTv.text =
                when(myFriend.starredFriendGender) {
                    1-> "남자"
                    else -> "여자"
                }
            GlideApp.with(binding.myFriendListProfileIdTv.context)
                .load(myFriend.starredFriendImgUrl)
                .into(binding.myFriendListProfileImageIv)

        }
    }
}