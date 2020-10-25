package com.makeus.wisdomexchange.src.wisdom_detail

import android.content.Intent
import android.os.Bundle
import com.makeus.wisdomexchange.R
import com.makeus.wisdomexchange.src.BaseActivity
import com.makeus.wisdomexchange.src.main.MainActivity
import kotlinx.android.synthetic.main.activity_done.*

class DoneActivity : BaseActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_done)

        initView()
    }

    private fun initView() {
        cl_ok_btn.setOnClickListener {
            startActivity(Intent(applicationContext, MainActivity::class.java).apply {
                addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP or Intent.FLAG_ACTIVITY_SINGLE_TOP)
            })
        }
    }
}