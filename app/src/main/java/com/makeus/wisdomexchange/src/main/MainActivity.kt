package com.makeus.wisdomexchange.src.main

import android.os.Bundle
import com.makeus.wisdomexchange.R
import com.makeus.wisdomexchange.src.BaseActivity

class MainActivity : BaseActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initView()
    }

    private fun initView() {
    }
}