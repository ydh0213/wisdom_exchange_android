package com.makeus.wisdomexchange.src.main.notification

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.makeus.wisdomexchange.R

class NotificationFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_notification, container, false)

        initView(view)

        return view
    }

    private fun initView(view: View?) {
    }

    companion object {
        @JvmStatic
        fun newInstance() = NotificationFragment()
    }
}