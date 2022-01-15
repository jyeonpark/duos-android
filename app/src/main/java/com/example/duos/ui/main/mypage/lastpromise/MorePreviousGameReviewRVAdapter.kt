package com.example.duos.ui.main.mypage.lastpromise


import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.duos.data.entities.MorePreviousPlayer
import com.example.duos.databinding.MorePreviousGamePlayerItemBinding

class MorePreviousGameReviewRVAdapter(private val morePreviousPlayerList: ArrayList<MorePreviousPlayer>) :
    RecyclerView.Adapter<MorePreviousGameReviewRVAdapter.ViewHolder>() {


    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): MorePreviousGameReviewRVAdapter.ViewHolder {
        val binding: MorePreviousGamePlayerItemBinding = MorePreviousGamePlayerItemBinding.inflate(
            LayoutInflater.from(parent.context)
        )
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(
        holder: MorePreviousGameReviewRVAdapter.ViewHolder,
        position: Int
    ) {
        holder.bind(morePreviousPlayerList[position])
    }

    override fun getItemCount(): Int = morePreviousPlayerList.size


    inner class ViewHolder(val binding: MorePreviousGamePlayerItemBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(morePreviousGame: MorePreviousPlayer) {
            binding.morePreviousGamePlayerIv.setImageResource(morePreviousGame.morePreviousProfileImg!!)
            binding.morePreviousGamePlayerNicknameTv.text =
                morePreviousGame.morePreviousProfileNickname
            binding.morePreviousGamePlayTimeTv.text = morePreviousGame.morePreviousTimeOfGame
        }
    }

}