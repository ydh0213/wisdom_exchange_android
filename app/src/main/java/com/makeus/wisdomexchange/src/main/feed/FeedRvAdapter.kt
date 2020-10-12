package com.makeus.wisdomexchange.src.main.feed

import android.view.LayoutInflater
import android.view.View
import android.view.View.GONE
import android.view.View.VISIBLE
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.RequestManager
import com.makeus.wisdomexchange.R
import com.makeus.wisdomexchange.src.main.feed.models.Feed
import kotlinx.android.synthetic.main.item_feed.view.*

class FeedRvAdapter(private val glide: RequestManager) :
    RecyclerView.Adapter<FeedRvAdapter.ViewHolder>() {
    private val feedList = arrayListOf<Feed>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_feed, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(feedList[position])
    }

    override fun getItemCount(): Int = feedList.size

    fun add(item: Feed) = feedList.add(item)

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(feed: Feed) {
            itemView.apply {
                tv_writer.text = feed.nick_name
                tv_time.text = feed.createTime
                tv_heart_count.text = feed.likeCnt.toString()
                tv_comment_count.text = feed.CommentCnt.toString()
                tv_content.text = feed.content
            }
            if (feed.post_image == null || feed.post_image!!.isEmpty())
                itemView.iv_photo.visibility = GONE
            else {
                itemView.iv_photo.visibility = VISIBLE
                glide.load(feed.post_image)
                    .centerCrop()
                    .into(itemView.iv_photo)
            }
        }
    }
}
