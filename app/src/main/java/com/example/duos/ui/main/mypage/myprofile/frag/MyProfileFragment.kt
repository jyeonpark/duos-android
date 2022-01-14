package com.example.duos.ui.main.mypage.myprofile.frag

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.duos.R
import com.example.duos.data.entities.Review
import com.example.duos.databinding.FragmentMyProfileBinding
import com.example.duos.ui.main.mypage.myprofile.ProfileReviewRVAdapter

class MyProfileFragment : Fragment() {

    private var _binding : FragmentMyProfileBinding? =null
    private val binding get() = _binding
    private var reviewDatas = ArrayList<Review>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentMyProfileBinding.inflate(inflater,container, false)

        reviewDatas.apply {
            add(Review(R.drawable.tennis_racket_img_4, "5.0", "koko0311_1","처음 뵀는데 어색하지 않고, 즐겁게 플레이 했습니다. 같은 동네에 사시는 분이라 처음 뵀는데 어색하지 않고, 즐겁게 플레이 했습니다. 같은 동네에 사시는 분이라 처음 뵀는데 어색하지 않고, 즐겁게 플레이 했습니다. 같은 동네에 사시는 분이라 처음 뵀는데 어색하지 않고, 즐겁게 플레이 했습니다. 같은 동네에 사시는 분이라"))
            add(Review(R.drawable.tennis_racket_img_4, "3.0", "koko0311_2","처음 뵀는데 어색하지 않고, 즐겁게 플레이 했습니다. 같은 동네에 사시는 분이라 처음 뵀는데 어색하지 않고, 즐겁게 플레이 했습니다. 같은 동네에 사시는 분이라 처음 뵀는데 어색하지 않고, 즐겁게 플레이 했습니다. 같은 동네에 사시는 분이라 처음 뵀는데 어색하지 않고, 즐겁게 플레이 했습니다. 같은 동네에 사시는 분이라"))
            add(Review(R.drawable.tennis_racket_img_4, "4.0", "koko0311_3","처음 뵀는데 어색하지 않고, 즐겁게 플레이 했습니다. 같은 동네에 사시는 분이라 처음 뵀는데 어색하지 않고, 즐겁게 플레이 했습니다. 같은 동네에 사시는 분이라 처음 뵀는데 어색하지 않고, 즐겁게 플레이 했습니다. 같은 동네에 사시는 분이라 처음 뵀는데 어색하지 않고, 즐겁게 플레이 했습니다. 같은 동네에 사시는 분이라"))
            add(Review(R.drawable.tennis_racket_img_4, "5.0", "koko0311_4","처음 뵀는데 어색하지 않고, 즐겁게 플레이 했습니다. 같은 동네에 사시는 분이라 처음 뵀는데 어색하지 않고, 즐겁게 플레이 했습니다. 같은 동네에 사시는 분이라 처음 뵀는데 어색하지 않고, 즐겁게 플레이 했습니다. 같은 동네에 사시는 분이라 처음 뵀는데 어색하지 않고, 즐겁게 플레이 했습니다. 같은 동네에 사시는 분이라"))

        }

        // 더미 데이터와 Adapter 연결
        val profileReviewRVAdapter = ProfileReviewRVAdapter(reviewDatas)
        // 리사이클러뷰에 어댑터 연결
        binding!!.playingReviewContentRv.adapter = profileReviewRVAdapter
        //레이아웃 매니저 설정
        // applicationContext??????
        binding!!.playingReviewContentRv.layoutManager = LinearLayoutManager(context,
            LinearLayoutManager.VERTICAL, false)


        return binding!!.root
    }

}