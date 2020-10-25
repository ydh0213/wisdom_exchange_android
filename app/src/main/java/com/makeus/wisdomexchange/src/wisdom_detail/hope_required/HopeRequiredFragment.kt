package com.makeus.wisdomexchange.src.wisdom_detail.hope_required

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.makeus.wisdomexchange.R
import kotlinx.android.synthetic.main.fragment_hope_required.*

class HopeRequiredFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_hope_required, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initView(view)
    }

    private fun initView(view: View) {
        // TODO: 테스트 코드. 나중에 삭제해야 함
        cl_tue.isSelected = true
        cl_thu.isSelected = true
        cl_sat.isSelected = true
    }

    companion object {
        fun newInstance() = HopeRequiredFragment()
    }
}