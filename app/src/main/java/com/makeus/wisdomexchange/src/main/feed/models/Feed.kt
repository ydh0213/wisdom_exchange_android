package com.makeus.wisdomexchange.src.main.feed.models

class Feed (
    var post_id: Int,
    var nick_name: String,
    var content: String,
    var createTime: String,
    var post_image: String?,
    var likeCnt: Int,
    var CommentCnt: Int
)