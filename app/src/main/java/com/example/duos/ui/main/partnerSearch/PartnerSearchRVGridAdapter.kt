package com.example.duos.ui.main.partnerSearch

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.duos.data.entities.RecommendedPartner
import com.example.duos.databinding.ItemRecommendedPartnerGridBinding

class PartnerSearchRVGridAdapter(private val recommendedPartnerList: ArrayList<RecommendedPartner>, private var width: Int): RecyclerView.Adapter<PartnerSearchRVGridAdapter.ViewHolder>() {
    //private val recommendedPartners = ArrayList<RecommendedPartner>()

    // 클릭 인터페이스 정의
    interface recommendedPartnerItemClickListener{
        fun onItemClick(recommendedPartner: RecommendedPartner)
    }

    // 리스너 객체를 전달받는 함수랑 리스너 객체를 저장할 변수
    private lateinit var mItemClickListener: recommendedPartnerItemClickListener

    fun setRecommendedPartnerItemClickListener(itemClickListener: recommendedPartnerItemClickListener){
        mItemClickListener = itemClickListener
    }

    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): ViewHolder {
        val binding: ItemRecommendedPartnerGridBinding = ItemRecommendedPartnerGridBinding.inflate(LayoutInflater.from(viewGroup.context), viewGroup, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(recommendedPartnerList[position])
    }

    override fun getItemCount(): Int = recommendedPartnerList.size

//    fun addRecommendedPartners(recommendedPartners: ArrayList<RecommendedPartner>){
//        this.recommendedPartners.clear()
//        this.recommendedPartners.addAll(recommendedPartners)
//
//        notifyDataSetChanged()
//    }

    inner class ViewHolder(val binding: ItemRecommendedPartnerGridBinding): RecyclerView.ViewHolder(binding.root) {
        fun bind(recommendedPartner : RecommendedPartner){
            binding.partnerSearchRecommendedPartnerIv.setImageResource(recommendedPartner.profileImg!!)
            binding.partnerSearchRecommendedPartnerLayout.layoutParams.width = width
            binding.partnerSearchRecommendedPartnerLocationTv.text = recommendedPartner.location
            binding.partnerSearchRecommendedPartnerBallCapabilityTv.text = recommendedPartner.ballCapacity
            binding.partnerSearchRecommendedPartnerIdTv.text = recommendedPartner.id
            binding.partnerSearchRecommendedPartnerAgeTv.text = recommendedPartner.age
            binding.partnerSearchRecommendedPartnerStarRatingTv.text = recommendedPartner.starRating.toString()
            binding.partnerSearchRecommendedPartnerReviewCountTv.text = recommendedPartner.reviewCount.toString()
        }
    }
}