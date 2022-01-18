package com.example.duos.ui.main.mypage.notion

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.View.GONE
import android.view.View.VISIBLE
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.duos.databinding.FragmentNotionBinding


class NotionFragment : Fragment() {

    private var _binding: FragmentNotionBinding? = null
    private val binding get() = _binding
    private var notionshown = false

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentNotionBinding.inflate(inflater, container, false)


        // 서비스 업데이트 공지사항 펼치기/펼치지 않기
        binding!!.btnShowServiceUpdateCl.setOnClickListener {
            if (notionshown == false) {
                notionshown = !notionshown
                binding!!.notionInfoTv.visibility = VISIBLE
                binding!!.btnShowServiceUpdateIv.visibility = GONE
                binding!!.btnShownServiceUpdateIv.visibility = VISIBLE
            } else {
                notionshown = !notionshown
                binding!!.notionInfoTv.visibility = GONE
                binding!!.btnShowServiceUpdateIv.visibility = VISIBLE
                binding!!.btnShownServiceUpdateIv.visibility = GONE
            }
        }






        return binding!!.root
    }


}