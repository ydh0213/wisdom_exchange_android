package com.makeus.wisdomexchange.src.wisdom_detail

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.makeus.wisdomexchange.src.wisdom_detail.exchange_reviews.ExchangeReviewsFragment
import com.makeus.wisdomexchange.src.wisdom_detail.hope_required.HopeRequiredFragment
import com.makeus.wisdomexchange.src.wisdom_detail.hope_wisdom.HopeWisdomFragment
import com.makeus.wisdomexchange.src.wisdom_detail.my_wisdom.MyWisdomFragment

class WisdomInfoVp2Adapter(fa: FragmentActivity) :
    FragmentStateAdapter(fa) {
    private val myWisdomFragment = MyWisdomFragment.newInstance()
    private val hopeWisdomFragment = HopeWisdomFragment.newInstance()
    private val hopeRequiredFragment = HopeRequiredFragment.newInstance()
    private val exchangeReviewsFragment = ExchangeReviewsFragment.newInstance()

    override fun getItemCount(): Int = 4

    override fun createFragment(position: Int): Fragment {
        return when (position) {
            0 -> myWisdomFragment
            1 -> hopeWisdomFragment
            2 -> hopeRequiredFragment
            3 -> exchangeReviewsFragment
            else -> myWisdomFragment
        }
    }
}
