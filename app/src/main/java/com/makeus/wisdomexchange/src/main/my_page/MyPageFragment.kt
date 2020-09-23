package com.makeus.wisdomexchange.src.main.my_page

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.makeus.wisdomexchange.R

class MyPageFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_my_page, container, false)

        initView(view)

        return view
    }

    private fun initView(view: View?) {
    }

    companion object {
        @JvmStatic
        fun newInstance() = MyPageFragment()
    }
}