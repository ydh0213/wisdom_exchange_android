package com.makeus.wisdomexchange.src.wisdom_detail

import android.os.Bundle
import com.bumptech.glide.Glide
import com.google.android.material.tabs.TabLayoutMediator
import com.makeus.wisdomexchange.R
import com.makeus.wisdomexchange.src.BaseActivity
import kotlinx.android.synthetic.main.activity_wisdom_detail.*

class WisdomDetailActivity : BaseActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_wisdom_detail)

        initView()
    }

    private fun initView() {
        initVp2()
    }

    private fun initVp2() {
        val photoVp2Adapter = PhotoVp2Adapter(Glide.with(this))
        vp2_photo.adapter = photoVp2Adapter

        // TODO: 테스트 코드. 나중에 삭제해야 함
        photoVp2Adapter.addAll(
            listOf(
                "https://image.gamechosun.co.kr/wlwl_upload/dataroom/common/2018/10/03/350157_1538559366.jpg",
                "https://cdn.clien.net/web/api/file/F01/3754728/9807d4bde03b4dd08ad.JPG",
                "https://img.animalplanet.co.kr/news/2020/02/05/700/62i8dsm805t822t059yt.jpg"
            )
        )

        TabLayoutMediator(tl_photo_indicator, vp2_photo) { tab, position -> tab.select() }.attach()
    }
}