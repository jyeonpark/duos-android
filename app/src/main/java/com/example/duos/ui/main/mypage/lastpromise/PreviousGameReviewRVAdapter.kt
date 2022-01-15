package com.example.duos.ui.main.mypage.lastpromise

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.duos.data.entities.PreviousPlayer
import com.example.duos.databinding.PreviousGamePlayerItemBinding

class PreviousGameReviewRVAdapter(private val previousGamePlayerList: ArrayList<PreviousPlayer>) :
    RecyclerView.Adapter<PreviousGameReviewRVAdapter.ViewHolder>() {

    interface PreviousPlayerItemClickListener {
        fun onItemClick(previousgame: PreviousPlayer)
    }

    private lateinit var mItemClickListener: PreviousPlayerItemClickListener

    fun writeReviewItemClickListener(itemClickListener: PreviousPlayerItemClickListener) {
        mItemClickListener = itemClickListener
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): PreviousGameReviewRVAdapter.ViewHolder {
        val binding: PreviousGamePlayerItemBinding = PreviousGamePlayerItemBinding.inflate(
            LayoutInflater.from(parent.context)
        )
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: PreviousGameReviewRVAdapter.ViewHolder, position: Int) {
        holder.bind(previousGamePlayerList[position])

        holder.itemView.setOnClickListener { mItemClickListener.onItemClick(previousGamePlayerList[position]) }
    }

    override fun getItemCount(): Int = previousGamePlayerList.size

    inner class ViewHolder(val binding: PreviousGamePlayerItemBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(previousgame: PreviousPlayer) {
            binding.previousGamePlayerIv.setImageResource(previousgame.previousProfileImg!!)
//            previousgame.previousProfileImg?.let { binding.previousGamePlayerIv.setImageResource(it) }
            binding.previousGamePlayerNicknameTv.text = previousgame.previousProfileNickname
            binding.previousGamePlayTimeTv.text = previousgame.previousTimeOfGame
        }
    }
}

