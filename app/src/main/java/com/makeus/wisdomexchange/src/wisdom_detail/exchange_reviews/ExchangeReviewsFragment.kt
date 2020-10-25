package com.makeus.wisdomexchange.src.wisdom_detail.exchange_reviews

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.bumptech.glide.Glide
import com.makeus.wisdomexchange.R
import com.makeus.wisdomexchange.src.wisdom_detail.exchange_reviews.models.Review
import kotlinx.android.synthetic.main.fragment_exchange_reviews.*

class ExchangeReviewsFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_exchange_reviews, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initView(view)
    }

    private fun initView(view: View) {
        val reviewRvAdapter = ReviewRvAdapter(Glide.with(this))
        rv_reviews.apply {
            layoutManager = LinearLayoutManager(context)
            adapter = reviewRvAdapter
        }

        // TODO: 테스트 코드. 나중에 삭제해야 함
        reviewRvAdapter.add(Review("https://www.animesunrise.com/wp-content/uploads/2020/05/uzaki-visual.jpg", "uzaki", 4.0F,
            "정말 좋았습니다! 친절하게 완전히 0부터 다 알려주시는데 알기 쉽고 step by step으로 진행해서 금방 입문 단계를 뗄 수 있었습니다. 본인만의 노하우도 알려주셔서 더욱 잘할 수 있었습니다."))
        reviewRvAdapter.add(Review(null, "익명의 사나이", 4.7F,
            "적절한 예시를 들어주면서 설명해주셔서 이해하기 쉽고 금방금방 따라갈 수 있었습니다. 강추!!!"))
    }

    companion object {
        fun newInstance() = ExchangeReviewsFragment()
    }
}