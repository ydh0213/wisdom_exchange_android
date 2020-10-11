package com.makeus.wisdomexchange.src.main.notification

import android.view.LayoutInflater
import android.view.View
import android.view.View.GONE
import android.view.View.VISIBLE
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.Adapter
import com.bumptech.glide.RequestManager
import com.makeus.wisdomexchange.R
import com.makeus.wisdomexchange.src.main.notification.models.Noti
import kotlinx.android.synthetic.main.item_noti.view.*

class NotiRvAdapter(private val glide: RequestManager) : Adapter<NotiRvAdapter.ViewHolder>() {
    private val notiList = arrayListOf<Noti>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_noti, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(notiList[position])
    }

    override fun getItemCount(): Int = notiList.size

    fun add(noti: Noti) = notiList.add(noti)

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(noti: Noti) {
            if (noti.profile_img != null)
                glide.load(noti.profile_img)
                    .override(300)
                    .centerCrop()
                    .circleCrop()
                    .into(itemView.iv_profile)

            if (noti.isSender == 1) { // 내가 남에게 요청 보냄
                if (noti.isExchanged == 1) { // 수락 완료
                    itemView.tv_title.text =
                        itemView.context.getString(R.string.kr_wisdom_exchange_accept_request)

                    itemView.tv_description.text =
                        itemView.context.getString(R.string.kr_wisdom_exchange_request_from_me_to_other_accept_description)
                            .replace("nickname", noti.opponent_nick)

                    itemView.btn_see_wisdom_exchange_detail.visibility = GONE
                    itemView.btn_accept.visibility = GONE
                    itemView.btn_write_evaluation.visibility = GONE
                    itemView.tv_contact_info.visibility = VISIBLE
                    itemView.tv_phone_number.visibility = VISIBLE
                } else { // 신청한 상태
                    itemView.tv_title.text =
                        itemView.context.getString(R.string.kr_wisdom_exchange_request)

                    itemView.tv_description.text =
                        itemView.context.getString(R.string.kr_wisdom_exchange_request_from_me_to_other_description)
                            .replace("nickname", noti.opponent_nick)

                    itemView.btn_see_wisdom_exchange_detail.visibility = VISIBLE
                    itemView.btn_accept.visibility = GONE
                    itemView.btn_write_evaluation.visibility = GONE
                    itemView.tv_contact_info.visibility = GONE
                    itemView.tv_phone_number.visibility = GONE
                }
            } else { // 남이 나에게 요청함
                if (noti.isExchanged == 1) { // 수락 완료
                    itemView.tv_title.text =
                        itemView.context.getString(R.string.kr_wisdom_exchange_accept_request)

                    itemView.tv_description.text =
                        itemView.context.getString(R.string.kr_wisdom_exchange_request_from_other_to_me_accept_description)
                            .replace("nickname", noti.opponent_nick)

                    itemView.btn_see_wisdom_exchange_detail.visibility = GONE
                    itemView.btn_accept.visibility = GONE
                    itemView.btn_write_evaluation.visibility = GONE
                    itemView.tv_contact_info.visibility = VISIBLE
                    itemView.tv_phone_number.visibility = VISIBLE
                } else { // 신청받은 상태
                    itemView.tv_title.text =
                        itemView.context.getString(R.string.kr_wisdom_exchange_request)

                    itemView.tv_description.text =
                        itemView.context.getString(R.string.kr_wisdom_exchange_request_from_other_to_me_description)
                            .replace("nickname", noti.opponent_nick)

                    itemView.btn_see_wisdom_exchange_detail.visibility = VISIBLE
                    itemView.btn_accept.visibility = VISIBLE
                    itemView.btn_write_evaluation.visibility = GONE
                    itemView.tv_contact_info.visibility = GONE
                    itemView.tv_phone_number.visibility = GONE
                }
            }

            itemView.tv_date_time.text = noti.updateTime
        }
    }
}
