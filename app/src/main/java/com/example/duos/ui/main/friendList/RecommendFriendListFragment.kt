package com.example.duos.ui.main.friendList


import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.duos.R
import com.example.duos.data.entities.RecommendedFriend
import com.example.duos.data.remote.myFriendList.FriendListService
import com.example.duos.data.remote.myFriendList.RecommendedFriendListOnDate
import com.example.duos.databinding.FragmentRecommendFriendListBinding
import com.example.duos.ui.BaseFragment
import com.example.duos.utils.getFriendListDiaglogNotShowing
import org.threeten.bp.LocalDate
import org.threeten.bp.Period
import org.threeten.bp.format.DateTimeFormatter
import org.w3c.dom.Text


class RecommendFriendListFragment() :
    BaseFragment<FragmentRecommendFriendListBinding>(FragmentRecommendFriendListBinding::inflate),
    RecommendedFriendListView {

    private var adapterList = arrayOfNulls<RecommendFriendListRVAdapter>(8)

    override fun initAfterBinding() {
        FriendListService.recommendedFriendList(this, 1)
    }

    override fun onGetRecommendedFriendListSuccess(starredFriendList: List<RecommendedFriendListOnDate>) {

        Log.d("recommend","ongetSuccess")

        if (!getFriendListDiaglogNotShowing()) {
            activity?.supportFragmentManager?.let { fragmentManager ->
                FriendListDialogFragment().show(
                    fragmentManager,
                    "친구목록 다이얼로그"
                )
            }
        }
        // starredFriendList를 날짜별로 파싱하기
//        Log.d("받은 것", starredFriendList.toString())

        // 날짜 파싱 & Dday 별로 recyclerview 에 매칭
        for (recommendedFriendListOnData in starredFriendList) {
            val recommendedAt = recommendedFriendListOnData.recommendedDate
            val formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss.SSSXXX")
            val date = LocalDate.parse(recommendedAt, formatter)
            val period: Int = 7 - (Period.between(date, LocalDate.now()).days)

            var recyclerviewId: Int = resources.getIdentifier(
                "recommend_friend_list_d_" + period.toString()
                        + "_recyclerview_rv", "id", requireActivity().packageName
            )

            // recyclerview 설정 & VISIBLE 하게 하기
            var recyclerview: RecyclerView = requireView().findViewById(recyclerviewId)
            recyclerview.visibility = View.VISIBLE
            recyclerview.layoutManager =
                LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
            adapterList[period] =
                RecommendFriendListRVAdapter(recommendedFriendListOnData.recommendedFriendList as ArrayList<RecommendedFriend>)
            recyclerview.adapter = adapterList[period]
            recyclerview.itemAnimator = null

            // D-day text 설정 & VISIBLE 하게 하기
            var textviewId: Int = resources.getIdentifier(
                "recommend_friend_list_d_" + period.toString()
                        + "_text_tv", "id", requireActivity().packageName
            )
            var textview: TextView = requireView().findViewById(textviewId)
            textview.visibility = View.VISIBLE

            adapterList[period]?.setMyItemClickListener(object :
                RecommendFriendListRVAdapter.MyItemClickListener {
                override fun onDeleteFriend(friendId: String) {

                }

                override fun onAddFriend(friendId: String) {

                }

                override fun onDeleteText() {
                    textview.visibility = View.GONE
                }

            })

        }
    }

    override fun onGetRecommendedFriendListFailure(code: Int, message: String) {
        showToast("code : $code, message : $message")
    }
}