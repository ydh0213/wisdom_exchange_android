package com.makeus.wisdomexchange.src.main.notification

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.bumptech.glide.Glide
import com.makeus.wisdomexchange.R
import com.makeus.wisdomexchange.src.main.notification.models.Noti
import kotlinx.android.synthetic.main.fragment_noti.*

class NotiFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_noti, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initView(view)
    }

    private fun initView(view: View) {
        initRv(view)
    }

    private fun initRv(view: View) {
        val notiRvAdapter = NotiRvAdapter(Glide.with(this))
        rv_noti.apply {
            layoutManager = LinearLayoutManager(context)
            adapter = notiRvAdapter
        }

        // TODO: 테스트 코드. 나중에 삭제해야 함
        notiRvAdapter.add(Noti(9, 32, 4, "2020-10-08 23:44:27", 1, "uzaki", "https://www.animesunrise.com/wp-content/uploads/2020/05/uzaki-visual.jpg", 1, "010-8744-4444", 0))
        notiRvAdapter.add(Noti(9, 32, 4, "2020-10-07 12:59:59", 0, "jh.Ahn", "https://dimg.donga.com/wps/NEWS/IMAGE/2019/11/02/98184553.2.jpg", 1, null, 1))
        notiRvAdapter.add(Noti(9, 32, 4, "2020-10-06 18:16:03", 1, "wowcyan", null, 1, "010-5555-1111", 1))
        notiRvAdapter.add(Noti(9, 32, 4, "2020-10-06 04:06:00", 0, "bababaZZ_35", "https://i.pinimg.com/originals/15/6a/86/156a86c143634a2e444b673a7b373b46.jpg", 1, null, 0))
    }

    companion object {
        @JvmStatic
        fun newInstance() = NotiFragment()
    }
}