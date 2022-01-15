package com.example.duos.ui.main.mypage.lastpromise

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.duos.R
import com.example.duos.data.entities.MorePreviousPlayer
import com.example.duos.data.entities.PreviousPlayer
import com.example.duos.databinding.FragmentPreviousGameBinding


class PreviousGameFragment : Fragment() {

    private var _binding: FragmentPreviousGameBinding? = null
    private val binding get() = _binding
    private var previousPlayerDatas = ArrayList<PreviousPlayer>()
    private var morePreviousPlayerDatas = ArrayList<MorePreviousPlayer>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentPreviousGameBinding.inflate(inflater, container, false)

        previousPlayerDatas.apply {
            add(PreviousPlayer(R.drawable.dummy_mask_2, "tennislover01", "오늘 오후 8시"))
            add(PreviousPlayer(R.drawable.dummy_mask_3, "Elle23", "오늘 오후 8시"))

        }

        morePreviousPlayerDatas.apply {
            add(MorePreviousPlayer(R.drawable.dummy_mask_4, "seungeun11", "2022.01.07"))
        }

        // 어댑터 설정
        val previousGameReviewRVAdapter = PreviousGameReviewRVAdapter(previousPlayerDatas)
        val morePreviousGameReviewRVAdapter = MorePreviousGameReviewRVAdapter(morePreviousPlayerDatas)




        binding!!.notYetWriteReviewPlayerlistRv.adapter = previousGameReviewRVAdapter

        binding!!.notYetWriteReviewPlayerlistRv.layoutManager =
            LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)

        binding!!.alreadyWriteReviewPlayerlistRv.adapter = morePreviousGameReviewRVAdapter

        binding!!.alreadyWriteReviewPlayerlistRv.layoutManager =
            LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)


        previousGameReviewRVAdapter.writeReviewItemClickListener(object : PreviousGameReviewRVAdapter.PreviousPlayerItemClickListener{
            override fun onItemClick(previousgame: PreviousPlayer) {
                (context as PreviousGameActivity).supportFragmentManager.beginTransaction().replace(R.id.previous_game_into_fragment_container_fc, PreviousGameReviewFragment().apply {
                    arguments = Bundle().apply {
                        putInt("playerProfileImg", previousgame.previousProfileImg!!)
                        putString("playerNickname",previousgame.previousProfileNickname)
                    }
                }).commitAllowingStateLoss()
            }
        })

        return binding!!.root

    }

}