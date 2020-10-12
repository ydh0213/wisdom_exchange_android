package com.makeus.wisdomexchange.src.wisdom_detail

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.RequestManager
import com.makeus.wisdomexchange.R
import kotlinx.android.synthetic.main.item_wisdom_exchange.view.*

class PhotoVp2Adapter(private val glide: RequestManager) :
    RecyclerView.Adapter<PhotoVp2Adapter.ViewHolder>() {
    private val imgUrlList = mutableListOf<String>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_photo, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(imgUrlList[position])
    }

    override fun getItemCount(): Int = imgUrlList.size

    fun addAll(imgUrlList: List<String>) = this.imgUrlList.addAll(imgUrlList)

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(imgUrl: String) {
            if (!imgUrl.isEmpty())
                glide.load(imgUrl)
                    .centerCrop()
                    .into(itemView.iv_photo)
        }
    }
}
