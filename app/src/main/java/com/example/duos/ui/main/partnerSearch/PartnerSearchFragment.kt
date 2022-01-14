package com.example.duos.ui.main.partnerSearch

import android.content.Intent
import android.content.res.Resources
import android.util.DisplayMetrics
import android.util.Log
import android.util.TypedValue
import androidx.recyclerview.widget.GridLayoutManager
import com.example.duos.R
import com.example.duos.data.entities.RecommendedPartner
import com.example.duos.databinding.FragmentPartnerSearchBinding
import com.example.duos.ui.BaseFragment
import com.example.duos.ui.main.MainActivity

class PartnerSearchFragment(): BaseFragment<FragmentPartnerSearchBinding>(FragmentPartnerSearchBinding::inflate) {
    private var recommendedPartnerDatas = ArrayList<RecommendedPartner>()

    override fun initAfterBinding() {
        recommendedPartnerDatas.apply {
            // 서울시 마포구로 필터링됐을 떄를 가정
            // FLO clone coding 211110자 커밋 참고했음
            add(RecommendedPartner(R.drawable.partner_profile_img_1, "서울시 마포구", "구력 1년", "berlinalena", "30대", 4.8, 11))
            add(RecommendedPartner(R.drawable.partner_profile_img_2, "서울시 서대문구", "구력 3년", "time456 ","30대", 4.7, 21))
            add(RecommendedPartner(R.drawable.partner_profile_img_3, "서울시 마포구", "구력 2년", "qop123", "20대", 4.7, 15))
            add(RecommendedPartner(R.drawable.partner_profile_img_4, "서울시 마포구", "구력 1년", "Olivia", "30대", 4.6, 8))
            add(RecommendedPartner(R.drawable.partner_profile_img_2, "서울시 마포구", "구력 1년", "berlinalena", "30대", 4.8, 11))
            add(RecommendedPartner(R.drawable.partner_profile_img_1, "서울시 서대문구", "구력 3년", "time456 ","30대", 4.7, 21))
            add(RecommendedPartner(R.drawable.partner_profile_img_4, "서울시 마포구", "구력 2년", "qop123", "20대", 4.7, 15))
            add(RecommendedPartner(R.drawable.partner_profile_img_3, "서울시 마포구", "구력 1년", "Olivia", "30대", 4.6, 8))
            add(RecommendedPartner(R.drawable.partner_profile_img_1, "서울시 마포구", "구력 1년", "berlinalena", "30대", 4.8, 11))
            add(RecommendedPartner(R.drawable.partner_profile_img_2, "서울시 마포구", "구력 3년", "time456 ","30대", 4.7, 21))
        }

        binding.partnerSearchRecommendedPartnerRv.layoutManager = GridLayoutManager(context, 2)

        val deviceWidthPixels = resources.displayMetrics.widthPixels
        var space : Int = TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 16F, context?.resources?.displayMetrics).toInt()
        val widthPixels = (deviceWidthPixels - space * 3) / 2

        val partnerSearchRVGridAdapter = PartnerSearchRVGridAdapter(recommendedPartnerDatas, widthPixels)

        binding.partnerSearchRecommendedPartnerRv.adapter = partnerSearchRVGridAdapter

        var marginStart : Int = TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 16F, context?.resources?.displayMetrics).toInt()
        var marginTop : Int = TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 20F, context?.resources?.displayMetrics).toInt()
        var marginBottom : Int = TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 16F, context?.resources?.displayMetrics).toInt()

        binding.partnerSearchRecommendedPartnerRv.addItemDecoration(GridSpacingItemDecoration(marginStart, marginTop, marginBottom))

//        var bottomNavigationBarHeight : Int = TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 72F, context?.resources?.displayMetrics).toInt()   // 72는 bottomNavigationBar 높이
//
//        val resourceId = resources.getIdentifier("navigation_bar_height", "dimen", "android")
//        var deviceNavigationBarHeight = 0
//        if (resourceId > 0) {
//            deviceNavigationBarHeight = resources.getDimensionPixelSize(resourceId)
//        }
//        var deviceHeight = deviceNavigationBarHeight + bottomNavigationBarHeight
//        binding.partnerSearchLayout.setPadding(0,0,0,deviceHeight)

        binding.partnerSearchFilteringIc.setOnClickListener{
            startActivity(Intent(activity, PartnerFilterActivity::class.java))
        }

        partnerSearchRVGridAdapter.setRecommendedPartnerItemClickListener(object:PartnerSearchRVGridAdapter.recommendedPartnerItemClickListener{
            override fun onItemClick(recommendedPartner: RecommendedPartner) {
                // 파트너 세부 화면으로 이동
            }
        })
    }

    companion object {
        fun newInstance(): PartnerSearchFragment = PartnerSearchFragment()
    }
}