package com.makeus.wisdomexchange.src.main.feed.models

class Feed {
    var contents: String
    var writer: String
    var time: String
    var heartCount: Int
    var commentCount: Int

    constructor(
        contents: String,
        writer: String,
        time: String,
        heartCount: Int,
        commentCount: Int
    ) {
        this.contents = contents
        this.writer = writer
        this.time = time
        this.heartCount = heartCount
        this.commentCount = commentCount
    }
}
