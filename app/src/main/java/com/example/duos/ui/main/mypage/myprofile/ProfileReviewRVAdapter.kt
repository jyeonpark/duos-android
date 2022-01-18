package com.example.duos.ui.main.mypage.myprofile

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.duos.data.entities.MyProfileReview
import com.example.duos.databinding.MyPlayingReviewItemBinding

// 어댑터의 parameter : 데이터리스트. 이 어댑터의 ViewHolder 상속받기
class ProfileReviewRVAdapter(private val myProfileReviewList: ArrayList<MyProfileReview>) :
    RecyclerView.Adapter<ProfileReviewRVAdapter.ViewHolder>() {

    // ViewHolder 생성. (아이템 뷰 객체를 binding해서 뷰 홀더에 던져줌)
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ProfileReviewRVAdapter.ViewHolder {
        val binding: MyPlayingReviewItemBinding =
            MyPlayingReviewItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    // ViewHolder에 데이터를 binding (리사이클러뷰의 아이템(데이터)이 바뀔 때마다 실행됨)
    override fun onBindViewHolder(holder: ProfileReviewRVAdapter.ViewHolder, position: Int) {
        holder.bind(myProfileReviewList[position])
    }

    // 데이터 리스트의 크기
    override fun getItemCount(): Int = myProfileReviewList.size

    // 내부클래스 ViewHolder. bind 메서드 정의(리사이클러뷰의 아이템에 데이터리스트의 데이터 연결)
    inner class ViewHolder(val binding: MyPlayingReviewItemBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(myProfileReview: MyProfileReview) {
            binding.profileImgIv.setImageResource(myProfileReview.profileImg!!)
            binding.playerGradeTv.text = myProfileReview.playerGrade
            binding.playerReviewNicknameTv.text = myProfileReview.profileNickname
            binding.reviewContentTv.text = myProfileReview.review_content_tv
            // 여기에서 별의 갯수도 설정을 해주는 코드를 추가해주어야 되
        }
    }
}


