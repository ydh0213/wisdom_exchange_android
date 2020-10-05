package com.makeus.wisdomexchange.src.main.home

import android.content.Intent
import android.os.Bundle
import com.makeus.wisdomexchange.R
import com.makeus.wisdomexchange.src.BaseActivity
import com.makeus.wisdomexchange.src.main.home.HomeFragment.Companion.SORT_BY_INDEX
import kotlinx.android.synthetic.main.pop_up_activity_sort_by.*

class PopUpSortByActivity : BaseActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.pop_up_activity_sort_by)

        initView()
    }

    private fun initView() {
        cl_bg.setOnClickListener {
            val intent = Intent()
            if (iv_newest_radio_btn.isSelected) intent.putExtra(SORT_BY_INDEX, 0)
            else if (iv_hottest_radio_btn.isSelected) intent.putExtra(SORT_BY_INDEX, 1)
            else if (iv_reviews_radio_btn.isSelected) intent.putExtra(SORT_BY_INDEX, 2)
            setResult(RESULT_OK, intent)
            finish()
        }
        cl_content.setOnClickListener {}

        removeAll()
        when (intent.getIntExtra(SORT_BY_INDEX, 0)) {
            0 -> iv_newest_radio_btn.isSelected = true
            1 -> iv_hottest_radio_btn.isSelected = true
            2 -> iv_reviews_radio_btn.isSelected = true
        }

        cl_newest.setOnClickListener {
            removeAll()
            iv_newest_radio_btn.isSelected = true
            val intent = Intent()
            intent.putExtra(SORT_BY_INDEX, 0)
            setResult(RESULT_OK, intent)
            finish()
        }
        cl_hottest.setOnClickListener {
            removeAll()
            iv_hottest_radio_btn.isSelected = true
            val intent = Intent()
            intent.putExtra(SORT_BY_INDEX, 1)
            setResult(RESULT_OK, intent)
            finish()
        }
        cl_reviews.setOnClickListener {
            removeAll()
            iv_reviews_radio_btn.isSelected = true
            val intent = Intent()
            intent.putExtra(SORT_BY_INDEX, 2)
            setResult(RESULT_OK, intent)
            finish()
        }
    }

    private fun removeAll() {
        iv_newest_radio_btn.isSelected = false
        iv_hottest_radio_btn.isSelected = false
        iv_reviews_radio_btn.isSelected = false
    }

    override fun onPause() {
        super.onPause()
        overridePendingTransition(R.anim.fade_in, R.anim.fade_out)
    }
}