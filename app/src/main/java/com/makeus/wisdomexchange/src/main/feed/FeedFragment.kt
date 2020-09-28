package com.makeus.wisdomexchange.src.main.feed

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.makeus.wisdomexchange.R
import com.makeus.wisdomexchange.src.main.feed.models.Feed
import kotlinx.android.synthetic.main.fragment_feed.*

class FeedFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_feed, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initView(view)
    }

    private fun initView(view: View) {
        initRv(view)
    }

    private fun initRv(view: View) {
        val feedRvAdapter = FeedRvAdapter()
        rv_feed.apply {
            setHasFixedSize(true)
            layoutManager = LinearLayoutManager(context)
            adapter = feedRvAdapter
        }

        // TODO: 테스트 코드. 나중에 삭제해야 함
        feedRvAdapter.add(Feed("Lorem ipsum dolor sit amet, consectetur adipis elit, sed do eiusmod tempor incididunt", "익명", "오전 12:00", 0, 0))
        feedRvAdapter.add(Feed("피드 테스트", "운영자", "오전 4:15", 0, 0))
        feedRvAdapter.add(Feed("공지사항\n서버 점검이 있을 예정이므로 양해바랍니다.", "운영자", "오전 4:17", 2, 0))
        feedRvAdapter.add(Feed("Lorem ipsum dolor sit amet, consectetur adipis elit, sed do eiusmod tempor incididunt", "익명", "오전 12:00", 0, 0))
        feedRvAdapter.add(Feed("Lorem ipsum dolor sit amet, consectetur adipis elit, sed do eiusmod tempor incididunt Lorem ipsum dolor sit amet, consectetur adipis elit, sed do eiusmod tempor incididunt", "익명", "오전 12:00", 0, 0))
        feedRvAdapter.add(Feed("혹시 이거 아는 분 계세요?? 친구한테 받은건데 뭔지 모르겠어요", "익명", "오후 1:39", 17, 3))
        feedRvAdapter.add(Feed("OOTD 올려봅니다", "패피", "오후 4:05", 127, 16))
        feedRvAdapter.add(Feed("Lorem ipsum dolor sit amet, consectetur adipis elit, sed do eiusmod tempor incididunt Lorem ipsum dolor sit amet, consectetur adipis elit, sed do eiusmod tempor incididunt", "익명", "오전 12:00", 0, 0))
        feedRvAdapter.add(Feed("메이커스 파이팅입니다!!! 다들 힘내요~~~!", "MAKEUS TEAM", "오후 6:25", 999, 99))
        feedRvAdapter.add(Feed("가을이 온다... 흑흑 외로웡ㅇㅇ유ㅠㅠㅠㅠ", "윤디", "오후 7:27", 54, 35))
        feedRvAdapter.add(Feed("이걸 보는 자 다들 올해도 솔크를 보낼터이니 크킄ㅋ크ㅡ크킄나만당할순없지 전부 저주에 걸려버려라 아ㅏㅏ앙앙ㅇ아ㅏ아 솔로천국커플지옥 다 망해버려라ㅏㅏㅏㅏㅏㅏㅏㅏㅏㅏㅏㅏㅏㅏㅏㅏ", "???", "오후 7:29", 87, 5))
        feedRvAdapter.add(Feed("아아아니 이거 실화냐", "록", "오후 9:58", 60, 7))
    }

    companion object {
        @JvmStatic
        fun newInstance() = FeedFragment()
    }
}