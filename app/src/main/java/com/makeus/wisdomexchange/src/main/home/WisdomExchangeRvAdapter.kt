package com.makeus.wisdomexchange.src.main.home

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.setPadding
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.Adapter
import androidx.recyclerview.widget.RecyclerView.TEXT_ALIGNMENT_CENTER
import com.bumptech.glide.RequestManager
import com.google.android.material.chip.Chip
import com.makeus.wisdomexchange.R
import com.makeus.wisdomexchange.src.main.home.models.WisdomExchange
import com.makeus.wisdomexchange.src.wisdom_detail.WisdomDetailActivity
import kotlinx.android.synthetic.main.item_wisdom_exchange.view.*

class WisdomExchangeRvAdapter(private val fragment: Fragment, private val glide: RequestManager) :
    Adapter<WisdomExchangeRvAdapter.ViewHolder>() {
    private val WisdomExchangeList = arrayListOf<WisdomExchange>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_wisdom_exchange, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(WisdomExchangeList[position])
    }

    override fun getItemCount(): Int = WisdomExchangeList.size

    fun add(item: WisdomExchange) = WisdomExchangeList.add(item)

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(wisdomExchange: WisdomExchange) {
            if (!wisdomExchange.imgUrl.isEmpty())
                glide.load(wisdomExchange.imgUrl)
                    .centerCrop()
                    .into(itemView.iv_photo)

            itemView.apply {
                cl_bg.setOnClickListener {
                    val intent = Intent(fragment.activity, WisdomDetailActivity::class.java)
                    fragment.startActivity(intent)
                }
                tv_title.text = wisdomExchange.title
                tv_my_wisdom.text = wisdomExchange.myWisdom
                tv_hope_wisdom.text = wisdomExchange.hopeWisdom
                chip_group_my_wisdom_items.removeAllViews()
                chip_group_hope_wisdom_items.removeAllViews()

                tv_rate.text = wisdomExchange.rate.toString()
                tv_view_count.text = wisdomExchange.viewCount.toString()
                tv_favorite_count.text = wisdomExchange.favoriteCount.toString()
            }

            for (myWisdomItem in wisdomExchange.myWisdomItems) {
                val chip = Chip(itemView.context).apply {
                    isClickable = false
                    text = myWisdomItem
                    textSize = 8F
                    textAlignment = TEXT_ALIGNMENT_CENTER
                    chipStrokeWidth = 3F

                    minHeight = 0
                    minimumHeight = 0
                    chipMinHeight = 0F

                    chipStartPadding = 0F
                    chipEndPadding = 0F
                    textStartPadding = 0F
                    textEndPadding = 0F

                    setPadding(10)

                    setEnsureMinTouchTargetSize(false)
                    setChipBackgroundColorResource(R.color.transparent)
                    setChipStrokeColorResource(R.color.color_primary)
                    setTextColor(itemView.context.getColor(R.color.color_primary))
                    setRippleColorResource(R.color.transparent)
                }
                itemView.chip_group_my_wisdom_items.addView(chip)
            }

            for (hopeWisdomItem in wisdomExchange.hopeWisdomItems) {
                val chip = Chip(itemView.context).apply {
                    isClickable = false
                    text = hopeWisdomItem
                    textSize = 8F
                    textAlignment = TEXT_ALIGNMENT_CENTER
                    chipStrokeWidth = 3F

                    minHeight = 0
                    minimumHeight = 0
                    chipMinHeight = 0F

                    chipStartPadding = 0F
                    chipEndPadding = 0F
                    textStartPadding = 0F
                    textEndPadding = 0F

                    setPadding(10)

                    setEnsureMinTouchTargetSize(false)
                    setChipBackgroundColorResource(R.color.transparent)
                    setChipStrokeColorResource(R.color.color_accent)
                    setTextColor(itemView.context.getColor(R.color.color_accent))
                    setRippleColorResource(R.color.transparent)
                }
                itemView.chip_group_hope_wisdom_items.addView(chip)
            }
        }
    }
}
