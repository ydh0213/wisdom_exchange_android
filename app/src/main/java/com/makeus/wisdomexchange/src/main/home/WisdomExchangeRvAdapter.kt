package com.makeus.wisdomexchange.src.main.home

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.Adapter
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

    fun add(item: WisdomExchange) { items.add(item) }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(item: WisdomExchange) {
            // TODO: imgUrl 연결
            // itemView.iv_photo = Glide... (wisdomExchange.imgUrl)

            itemView.tv_title.text = item.title
            itemView.tv_my_wisdom.text = item.myWisdom
            itemView.tv_want_wisdom.text = item.wantWisdom
        }
    }
}
