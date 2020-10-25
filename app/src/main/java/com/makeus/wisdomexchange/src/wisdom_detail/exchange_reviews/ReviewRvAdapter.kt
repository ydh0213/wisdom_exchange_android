package com.makeus.wisdomexchange.src.wisdom_detail.exchange_reviews

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.RequestManager
import com.makeus.wisdomexchange.R
import com.makeus.wisdomexchange.src.wisdom_detail.exchange_reviews.models.Review
import kotlinx.android.synthetic.main.item_review.view.*

class ReviewRvAdapter(private val glide: RequestManager) :
    RecyclerView.Adapter<ReviewRvAdapter.ViewHolder>() {
    private val reviews = arrayListOf<Review>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ReviewRvAdapter.ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_review, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ReviewRvAdapter.ViewHolder, position: Int) {
        holder.bind(reviews[position])
    }

    override fun getItemCount(): Int = reviews.size

    fun add(review: Review) = reviews.add(review)

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(review: Review) {
            if (review.imgUrl?.isEmpty() == false)
                glide.load(review.imgUrl)
                    .centerCrop()
                    .circleCrop()
                    .into(itemView.iv_profile)

            itemView.tv_nickname.text = review.nickname
            itemView.rb_rating_stars.rating = review.rating
            itemView.tv_content.text = review.content
        }
    }
}
