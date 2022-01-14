package com.example.duos.ui.main.mypage.myprofile

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.duos.data.entities.Review
import com.example.duos.databinding.MyPlayingReviewItemBinding

// 어댑터의 parameter : 데이터리스트. 이 어댑터의 ViewHolder 상속받기
class ProfileReviewRVAdapter(private val reviewList: ArrayList<Review>) :
    RecyclerView.Adapter<ProfileReviewRVAdapter.ViewHolder>() {

    // ViewHolder 생성. (아이템 뷰 객체를 binding해서 뷰 홀더에 던져줌)
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ProfileReviewRVAdapter.ViewHolder {
        val binding: MyPlayingReviewItemBinding =
            MyPlayingReviewItemBinding.inflate(LayoutInflater.from(parent.context))
        return ViewHolder(binding)
    }

    // ViewHolder에 데이터를 binding (리사이클러뷰의 아이템(데이터)이 바뀔 때마다 실행됨)
    override fun onBindViewHolder(holder: ProfileReviewRVAdapter.ViewHolder, position: Int) {
        holder.bind(reviewList[position])
    }

    // 데이터 리스트의 크기
    override fun getItemCount(): Int = reviewList.size

    // 내부클래스 ViewHolder. bind 메서드 정의(리사이클러뷰의 아이템에 데이터리스트의 데이터 연결)
    inner class ViewHolder(val binding: MyPlayingReviewItemBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(review: Review) {
            binding.profileImgIv.setImageResource(review.profileImg!!)
            binding.playerGradeTv.text = review.playerGrade
            binding.playerReviewNicknameTv.text = review.profileNickname
            binding.reviewContentTv.text = review.review_content_tv
            // 여기에서 별의 갯수도 설정을 해주는 코드를 추가해주어야 되
        }
    }
}


