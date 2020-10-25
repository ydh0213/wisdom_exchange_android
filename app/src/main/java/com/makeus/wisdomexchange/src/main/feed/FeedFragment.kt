package com.makeus.wisdomexchange.src.main.feed

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.bumptech.glide.Glide
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
        val feedRvAdapter = FeedRvAdapter(Glide.with(this))
        rv_feed.apply {
            layoutManager = LinearLayoutManager(context)
            adapter = feedRvAdapter
        }

        // TODO: 테스트 코드. 나중에 삭제해야 함
        feedRvAdapter.add(Feed(1, "익명", "Lorem ipsum dolor sit amet, consectetur adipis elit, sed do eiusmod tempor incididunt", "오전 12:00", null, 0, 0))
        feedRvAdapter.add(Feed(2, "운영자", "피드 테스트", "오전 4:15", "https://i.pinimg.com/originals/76/47/9d/76479dd91dc55c2768ddccfc30a4fbf5.png", 0, 0))
        feedRvAdapter.add(Feed(3, "운영자", "공지사항\n서버 점검이 있을 예정이므로 양해바랍니다.", "오전 4:17", "", 2, 0))
        feedRvAdapter.add(Feed(4, "가짜개발자", "알고리즘 어려웡ㅇㅇ", "오전 12:00", null, 0, 0))
        feedRvAdapter.add(Feed(5, "익명", "Lorem ipsum dolor sit amet, consectetur adipis elit, sed do eiusmod tempor incididunt Lorem ipsum dolor sit amet, consectetur adipis elit, sed do eiusmod tempor incididunt", "오전 12:00", null, 0, 0))
        feedRvAdapter.add(Feed(6, "익명", "혹시 이거 아는 분 계세요?? 친구한테 받은건데 뭔지 모르겠어요", "오후 1:39", "https://image.fmkorea.com/files/attach/new/20180825/486616/72458075/1231630583/43e2b25138ce2397c43dca8b6a0fa40f.jpg", 17, 3))
        feedRvAdapter.add(Feed(7, "패피", "OOTD 올려봅니다", "오후 4:05", "https://i.pinimg.com/736x/52/3a/92/523a92bccc5e534c343a986f5b0f7878.jpg", 127, 16))
        feedRvAdapter.add(Feed(8, "익명", "Lorem ipsum dolor sit amet, consectetur adipis elit, sed do eiusmod tempor incididunt Lorem ipsum dolor sit amet, consectetur adipis elit, sed do eiusmod tempor incididunt", "오전 12:00", "https://makeawebsitehub.com/wp-content/uploads/2018/04/Favicons-1024x576.png", 0, 0))
        feedRvAdapter.add(Feed(9, "MAKEUS TEAM", "메이커스 파이팅입니다!!! 다들 힘내요~~~!", "오후 6:25", null, 999, 99))
        feedRvAdapter.add(Feed(10, "윤디", "가을이 온다... 흑흑 외로웡ㅇㅇ유ㅠㅠㅠㅠ", "오후 7:27", "https://dimg.donga.com/wps/NEWS/IMAGE/2013/11/11/58808007.3.jpg",   54, 35))
        feedRvAdapter.add(Feed(11, "???", "이걸 보는 자 다들 올해도 솔크를 보낼터이니 크킄ㅋ크ㅡ크킄나만당할순없지 전부 저주에 걸려버려라 아ㅏㅏ앙앙ㅇ아ㅏ아 솔로천국커플지옥 다 망해버려라ㅏㅏㅏㅏㅏㅏㅏㅏㅏㅏㅏㅏㅏㅏㅏㅏ", "오후 7:29", "https://jjalbang.today/files/jjalbox/2015/03/102_5516a42c36655_933.jpg", 87, 5))
        feedRvAdapter.add(Feed(12, "록", "아아아니 이거 실화냐", "오후 9:58", null, 60, 7))
        feedRvAdapter.add(Feed(13, "아이마스", "왜 나는 얘네들 사이에서...", "오전 12:00", "http://ram.komica2.net/00/src/1601988501524.jpg", 0, 0))
        feedRvAdapter.add(Feed(14, "아이마스", "왜 나는 얘네들 사이에서... (2)",  "오전 12:00", "http://ram.komica2.net/00/src/1601988443862.jpg", 0, 0))
        feedRvAdapter.add(Feed(15, "익명", "Lorem ipsum dolor sit amet, consectetur adipis elit, sed do eiusmod tempor incididunt", "오전 12:00", "", 0, 0))
        feedRvAdapter.add(Feed(16, "페이몬", "원신 요새 넘 재밌네요 원신 하는 분 계신가요", "오전 12:00", "https://post-phinf.pstatic.net/MjAyMDA4MjVfMTY1/MDAxNTk4MzUyMzg5MDk5.uSx55RCqy1yzbFcvGVTdbA1ZWoeZGeMpVMyuvyVDIEYg.h36_s8YhaD4tKTma30yTw6e_QoP4SKJ52C1OZeGcB2Eg.JPEG/IMG_5471.jpg", 0, 0))
    }

    companion object {
        @JvmStatic
        fun newInstance() = FeedFragment()
    }
}