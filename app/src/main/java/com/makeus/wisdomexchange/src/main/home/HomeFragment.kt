package com.makeus.wisdomexchange.src.main.home

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.makeus.wisdomexchange.R
import com.makeus.wisdomexchange.src.main.home.models.WisdomExchange
import kotlinx.android.synthetic.main.fragment_home.*

class HomeFragment : Fragment() {
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
        val sortedBySpinnerList = arrayListOf(
            getString(R.string.kr_sort_by_newest),
            getString(R.string.kr_sort_by_hottest),
            getString(R.string.kr_sort_by_reviews))
        val sortedBySpinnerAdapter = SortedBySpinnerAdapter(context!!,
            R.layout.support_simple_spinner_dropdown_item, sortedBySpinnerList)
        spinner_sorted_by.adapter = sortedBySpinnerAdapter

        initRv(view)
    }

    private fun initRv(view: View) {
        val wisdomExchangeRvAdapter = WisdomExchangeRvAdapter()
        rv_wisdom_exchange.apply {
            setHasFixedSize(true)
            layoutManager = LinearLayoutManager(context)
            adapter = wisdomExchangeRvAdapter
        }

        // TODO: 테스트 코드. 나중에 삭제해야 함
        wisdomExchangeRvAdapter.add(WisdomExchange("슬기 제목0", "내 슬기들0", "희망 슬기들0"))
        wisdomExchangeRvAdapter.add(WisdomExchange("슬기 제목1", "내 슬기들1", "희망 슬기들1"))
        wisdomExchangeRvAdapter.add(WisdomExchange("슬기 제목2", "내 슬기들2", "희망 슬기들2"))
        wisdomExchangeRvAdapter.add(WisdomExchange("슬기 제목3", "내 슬기들3", "희망 슬기들3"))
        wisdomExchangeRvAdapter.add(WisdomExchange("슬기 제목4", "내 슬기들4", "희망 슬기들4"))
        wisdomExchangeRvAdapter.add(WisdomExchange("슬기 제목5", "내 슬기들5", "희망 슬기들5"))
        wisdomExchangeRvAdapter.add(WisdomExchange("슬기 제목6", "내 슬기들6", "희망 슬기들6"))
        wisdomExchangeRvAdapter.add(WisdomExchange("드로잉 가르쳐드릴테니 코딩 가르쳐주실 분 구합니다", "드로잉 스케치 인물구도", "코딩 입문 웹 앱 개발 어떤거든"))
        wisdomExchangeRvAdapter.add(WisdomExchange("영어 잘하시는 분ㅠㅠ", "한국어 원어민, 일본어 N1, 중국어 중급", "영어"))
        wisdomExchangeRvAdapter.add(WisdomExchange("대학수학 기초 과외 급구", "발표스킬 자신감 토론 마인드셋 철학", "대학수학 기초 과외가능하신 분"))
    }

    class SortedBySpinnerAdapter(context: Context, resource: Int, objects: MutableList<String>) :
        ArrayAdapter<String>(context, resource, objects) {
        override fun getDropDownView(position: Int, convertView: View?, parent: ViewGroup): View {
            val view = super.getDropDownView(position, convertView, parent)
            if (view is TextView)
                view.setTextColor(view.getContext().resources.getColor(R.color.black,
                    dropDownViewTheme))
            return view
        }

        override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
            val view = super.getView(position, convertView, parent)
            if (view is TextView)
                view.setTextColor(view.getContext().resources.getColor(R.color.black,
                    dropDownViewTheme))
            return view
        }
    }

    companion object {
        @JvmStatic
        fun newInstance() = HomeFragment()
    }
}