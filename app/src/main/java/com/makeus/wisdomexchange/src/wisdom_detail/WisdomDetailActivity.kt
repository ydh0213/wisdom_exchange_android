package com.makeus.wisdomexchange.src.wisdom_detail

import android.os.Bundle
import android.view.View
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.viewpager2.widget.ViewPager2
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
        initPhotoVp2()

        cl_back_btn.setOnClickListener { finish() }

        val infoVp2Adapter = WisdomInfoVp2Adapter(this)
        vp2_widom_info.apply {
            adapter = infoVp2Adapter
            offscreenPageLimit = 3
        }
        vp2_widom_info.registerOnPageChangeCallback(object : ViewPager2.OnPageChangeCallback() {
            override fun onPageSelected(position: Int) {
                super.onPageSelected(position)
                val view = infoVp2Adapter.getView(position)
                view.post {
                    val wMeasureSpec =
                        View.MeasureSpec.makeMeasureSpec(view.width, View.MeasureSpec.EXACTLY)
                    val hMeasureSpec =
                        View.MeasureSpec.makeMeasureSpec(0, View.MeasureSpec.UNSPECIFIED)
                    view.measure(wMeasureSpec, hMeasureSpec)

                    if (vp2_widom_info.layoutParams.height != view.measuredHeight)
                        vp2_widom_info.layoutParams =
                            (vp2_widom_info.layoutParams as ConstraintLayout.LayoutParams)
                                .also { lp -> lp.height = view.measuredHeight }
                }
            }
        })

        TabLayoutMediator(tl_contents, vp2_widom_info) { tab, position ->
            tab.text = when (position) {
                0 -> getString(R.string.kr_my_wisdom)
                1 -> getString(R.string.kr_hope_wisdom)
                2 -> getString(R.string.kr_hope_required)
                3 -> getString(R.string.kr_exchange_reviews)
                else -> ""
            }
        }.attach()
    }

    private fun initPhotoVp2() {
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