package com.makeus.wisdomexchange.src.main.feed

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.makeus.wisdomexchange.R
import com.makeus.wisdomexchange.src.main.feed.models.Feed
import kotlinx.android.synthetic.main.item_feed.view.*

class FeedRvAdapter: RecyclerView.Adapter<FeedRvAdapter.ViewHolder>() {
    private val items = arrayListOf<Feed>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_feed, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(items[position])
    }

    override fun getItemCount(): Int = items.size

    fun add(item: Feed) = items.add(item)

    class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
        fun bind(item: Feed) {
            itemView.tv_content.text = item.contents
            itemView.tv_writer.text = item.writer
            itemView.tv_time.text = item.time
            itemView.tv_heart_count.text = item.heartCount.toString()
            itemView.tv_comment_count.text = item.commentCount.toString()
        }
    }
}
