package com.makeus.wisdomexchange.src.main.home

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.setPadding
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.Adapter
import androidx.recyclerview.widget.RecyclerView.TEXT_ALIGNMENT_CENTER
import com.google.android.material.chip.Chip
import com.makeus.wisdomexchange.R
import com.makeus.wisdomexchange.src.main.home.models.WisdomExchange
import kotlinx.android.synthetic.main.item_wisdom_exchange.view.*

class WisdomExchangeRvAdapter: Adapter<WisdomExchangeRvAdapter.ViewHolder>() {
    private val items = arrayListOf<WisdomExchange>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_wisdom_exchange, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(items[position])
    }

    override fun getItemCount(): Int = items.size

    fun add(item: WisdomExchange) = items.add(item)

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(item: WisdomExchange) {
            // TODO: imgUrl 연결
            // itemView.iv_photo = Glide... (wisdomExchange.imgUrl)

            itemView.tv_title.text = item.title
            itemView.tv_my_wisdom.text = item.myWisdom
            itemView.tv_hope_wisdom.text = item.hopeWisdom
            itemView.chip_group_my_wisdom_items.removeAllViews()
            itemView.chip_group_hope_wisdom_items.removeAllViews()
            for (myWisdomItem in item.myWisdomItems) {
                val chip = Chip(itemView.context)
                chip.isClickable = false
                chip.text = myWisdomItem
                chip.textSize = 10F
                chip.textAlignment = TEXT_ALIGNMENT_CENTER
                chip.chipStrokeWidth = 3F

                chip.minHeight = 0
                chip.minimumHeight = 0
                chip.chipMinHeight = 0F

                chip.chipStartPadding = 0F
                chip.chipEndPadding = 0F
                chip.textStartPadding = 0F
                chip.textEndPadding = 0F

                chip.setPadding(10)

                chip.setEnsureMinTouchTargetSize(false)
                chip.setChipBackgroundColorResource(R.color.transparent)
                chip.setChipStrokeColorResource(R.color.color_primary)
                chip.setTextColor(itemView.context.getColor(R.color.color_primary))
                itemView.chip_group_my_wisdom_items.addView(chip)
            }

            for (hopeWisdomItem in item.hopeWisdomItems) {
                val chip = Chip(itemView.context)
                chip.isClickable = false
                chip.text = hopeWisdomItem
                chip.textSize = 10F
                chip.textAlignment = TEXT_ALIGNMENT_CENTER
                chip.chipStrokeWidth = 3F

                chip.minHeight = 0
                chip.minimumHeight = 0
                chip.chipMinHeight = 0F

                chip.chipStartPadding = 0F
                chip.chipEndPadding = 0F
                chip.textStartPadding = 0F
                chip.textEndPadding = 0F

                chip.setPadding(10)

                chip.setEnsureMinTouchTargetSize(false)
                chip.setChipBackgroundColorResource(R.color.transparent)
                chip.setChipStrokeColorResource(R.color.color_accent)
                chip.setTextColor(itemView.context.getColor(R.color.color_accent))
                itemView.chip_group_hope_wisdom_items.addView(chip)
            }

            itemView.tv_rate.text = item.rate.toString()
            itemView.tv_view_count.text = item.viewCount.toString()
            itemView.tv_favorite_count.text = item.favoriteCount.toString()
        }
    }
}
