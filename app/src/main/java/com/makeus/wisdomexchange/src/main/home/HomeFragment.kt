package com.makeus.wisdomexchange.src.main.home

import android.app.Activity.RESULT_OK
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.bumptech.glide.Glide
import com.makeus.wisdomexchange.R
import com.makeus.wisdomexchange.src.main.home.models.WisdomExchange
import kotlinx.android.synthetic.main.fragment_home.*

class HomeFragment : Fragment() {
    private var selectedIndexSortBy = 0

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_home, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initView(view)
    }

    private fun initView(view: View) {
        cl_sorted_by.setOnClickListener {
            val intent = Intent(view.context, PopUpSortByActivity::class.java)
            intent.putExtra(SORT_BY_INDEX, selectedIndexSortBy)
            startActivityForResult(intent, REQUEST_SORT_BY)
            activity?.overridePendingTransition(R.anim.fade_in, R.anim.not_move)
        }

        initRv()
    }

    private fun initRv() {
        val wisdomExchangeRvAdapter = WisdomExchangeRvAdapter(this, Glide.with(this))
        rv_wisdom_exchange.apply {
            setHasFixedSize(true)
            layoutManager = LinearLayoutManager(context)
            adapter = wisdomExchangeRvAdapter
        }

        // TODO: 테스트 코드. 나중에 삭제해야 함
        wisdomExchangeRvAdapter.add(WisdomExchange("", "프로그래밍 ↔ 아트 교환", "프로그래밍", "아트",
            arrayListOf("C++", "Python"), arrayListOf("디자인", "영상"), 4.0, 123, 123))
        wisdomExchangeRvAdapter.add(WisdomExchange("https://upload2.inven.co.kr/upload/2018/04/15/bbs/i16501873220.jpg", "옵치 랭커입니다 피아노 배워보고 싶어요", "게임", "악기",
                arrayListOf("오버워치", "리듬게임"), arrayListOf("피아노"), 0.0, 0, 0))
        wisdomExchangeRvAdapter.add(WisdomExchange("https://i.ytimg.com/vi/MQ0xicHaWOQ/hqdefault.jpg", "음치탈출하실 분?", "음악", "기타",
                arrayListOf("보컬 트레이닝", "댄스"), arrayListOf("아무거나"), 1.1, 1, 1999))
        wisdomExchangeRvAdapter.add(WisdomExchange("https://encrypted-tbn0.gstatic.com/images?q=tbn%3AANd9GcQm5T1-ikKmhpXojdlzKhUZMXHPQo2lVQr2_Q", "암기법 전수해드립니다", "자기계발", "기타",
            arrayListOf("암기법"), arrayListOf("자기관리", "패션"), 4.4, 99999, 9))
        wisdomExchangeRvAdapter.add(WisdomExchange("https://assets.2ser.com/wp-content/aws/uploads/2018/02/21032555/411713-magician.jpg", "마술 배워보고 싶어요", "운동", "취미",
            arrayListOf("헬스 PT"), arrayListOf("마술"), 3.56, 413, 53))
        wisdomExchangeRvAdapter.add(WisdomExchange("https://handscoffee.com/data/cheditor4/1609/65ed35f3ff808f1b31ff70b19b19d484_AzACOXWdIhkrhAZKS6EH39.JPG", "요리 슬기 교환할 분 찾아여ㅠㅠㅠ", "라이프스타일", "라이프스타일",
            arrayListOf("양식", "제과제빵", "바리스타"), arrayListOf("한식", "일식", "중식"), 2.7, 10, 2))
        wisdomExchangeRvAdapter.add(WisdomExchange("https://www.forbes.fr/wp-content/uploads/2017/08/0731_lb-dj-marshmello_1200x630.jpg", "글쓰기 가르쳐주세오", "자기계발", "음악",
            arrayListOf("글쓰기"), arrayListOf("작곡", "DJ"), 5.0, 5, 5))
        wisdomExchangeRvAdapter.add(WisdomExchange("https://cdn.crowdpic.net/detail-thumb/thumb_d_B12DECD6BBDF50F0FC537798397B4F5E.jpg", "펜돌리기 고수 찾습니다 캘리그라피 가르쳐드려요!", "아트", "취미",
                arrayListOf("캘리그라피"), arrayListOf("펜돌리기"), 1.8, 3576, 444))
        wisdomExchangeRvAdapter.add(WisdomExchange("", "드로잉 가르쳐드릴테니 코딩 가르쳐주실 분 구합니다", "디자인", "프로그래밍",
            arrayListOf("드로잉", "스케치", "인물구도"), arrayListOf("코딩 입문", "웹", "앱"), 3.8, 107, 19))
        wisdomExchangeRvAdapter.add(WisdomExchange("https://i.imgur.com/KodkXuB.jpeg", "영어 잘하시는 분ㅠㅠ", "외국어", "외국어",
            arrayListOf("한국어", "일본어", "중국어"), arrayListOf("영어"), 4.8, 825, 36))
        wisdomExchangeRvAdapter.add(WisdomExchange("https://i.imgur.com/vasC9F9.png", "대학수학 기초 과외 급구", "기타", "수학",
            arrayListOf("발표스킬", "토론", "마인드셋"), arrayListOf("대학수학"), 3.32, 26, 0))
    }


    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (resultCode == RESULT_OK && requestCode == REQUEST_SORT_BY) {
            selectedIndexSortBy = data!!.getIntExtra(SORT_BY_INDEX, 0).also {
                when (it) {
                    0 -> tv_sorted_by.text = getString(R.string.kr_sort_by_newest)
                    1 -> tv_sorted_by.text = getString(R.string.kr_sort_by_hottest)
                    2 -> tv_sorted_by.text = getString(R.string.kr_sort_by_reviews)
                }

                // TODO: API 호출
                // wisdomExchangeRvAdapter.notifyDataSetChanged()
            }
        }
    }

    companion object {
        @JvmStatic
        fun newInstance() = HomeFragment()

        const val REQUEST_SORT_BY = 0
        const val SORT_BY_INDEX = "SORT_BY_INDEX"
    }
}