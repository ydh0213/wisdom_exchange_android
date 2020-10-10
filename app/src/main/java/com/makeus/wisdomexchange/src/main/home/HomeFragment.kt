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
        val wisdomExchangeRvAdapter = WisdomExchangeRvAdapter(Glide.with(this))
        rv_wisdom_exchange.apply {
            setHasFixedSize(true)
            layoutManager = LinearLayoutManager(context)
            adapter = wisdomExchangeRvAdapter
        }

        // TODO: 테스트 코드. 나중에 삭제해야 함
        wisdomExchangeRvAdapter.add(
            WisdomExchange(
                "",
                "슬기 교환서 제목", "프로그래밍", "아트", arrayListOf(
                    "C++",
                    "Python"
                ), arrayListOf("디자인", "영상"), 4.0, 123, 123
            )
        )
        wisdomExchangeRvAdapter.add(
            WisdomExchange(
                "https://i.imgur.com/58e6sXz.jpg",
                "슬기 제목0",
                "내 슬기들0",
                "희망 슬기들0",
                arrayListOf(),
                arrayListOf(),
                0.0,
                0,
                0
            )
        )
        wisdomExchangeRvAdapter.add(
            WisdomExchange(
                "https://i.imgur.com/RpMDsuF.jpg",
                "슬기 제목1",
                "내 슬기들1",
                "희망 슬기들1",
                arrayListOf("내 슬기"),
                arrayListOf(),
                1.1,
                1,
                1999
            )
        )
        wisdomExchangeRvAdapter.add(
            WisdomExchange(
                "https://i.imgur.com/q3ZKiTw.jpg",
                "슬기 제목2", "내 슬기들2", "희망 슬기들2", arrayListOf(), arrayListOf(
                    "희망슬기1",
                    "희망슬기2"
                ), 4.4, 99999, 9
            )
        )
        wisdomExchangeRvAdapter.add(
            WisdomExchange(
                "https://i.imgur.com/WMrDqWz.jpg",
                "슬기 제목3", "내 슬기들3", "희망 슬기들3", arrayListOf(
                    "내 슬기1",
                    "내 슬기2"
                ), arrayListOf("희망슬기"), 3.56, 413, 53
            )
        )
        wisdomExchangeRvAdapter.add(
            WisdomExchange(
                "https://i.imgur.com/SIquQS2.jpg",
                "슬기 제목4", "내 슬기들4", "희망 슬기들4", arrayListOf(), arrayListOf(
                    "희망슬기1234"
                ), 2.7, 10, 2
            )
        )
        wisdomExchangeRvAdapter.add(
            WisdomExchange(
                "https://i.imgur.com/lRDCzkG.jpg",
                "슬기 제목5", "내 슬기들5", "희망 슬기들5", arrayListOf("내 슬기"), arrayListOf(
                    "희망 슬기"
                ), 5.0, 5, 5
            )
        )
        wisdomExchangeRvAdapter.add(
            WisdomExchange(
                "https://i.imgur.com/BWNpfGp.jpg",
                "슬기 제목6",
                "내 슬기들6",
                "희망 슬기들6",
                arrayListOf(),
                arrayListOf(),
                1.8,
                3576,
                444
            )
        )
        wisdomExchangeRvAdapter.add(
            WisdomExchange(
                "",
                "드로잉 가르쳐드릴테니 코딩 가르쳐주실 분 구합니다", "디자인", "프로그래밍", arrayListOf(
                    "드로잉",
                    "스케치",
                    "인물구도"
                ), arrayListOf("코딩 입문", "웹", "앱"), 3.8, 107, 19
            )
        )
        wisdomExchangeRvAdapter.add(
            WisdomExchange(
                "https://i.imgur.com/KodkXuB.jpeg",
                "영어 잘하시는 분ㅠㅠ", "외국어", "외국어", arrayListOf(
                    "한국어",
                    "일본어",
                    "중국어"
                ), arrayListOf("영어"), 4.8, 825, 36
            )
        )
        wisdomExchangeRvAdapter.add(
            WisdomExchange(
                "https://i.imgur.com/vasC9F9.png",
                "대학수학 기초 과외 급구", "기타", "수학", arrayListOf(
                    "발표스킬",
                    "토론",
                    "마인드셋"
                ), arrayListOf("대학수학"), 3.32, 26, 0
            )
        )
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