package com.makeus.wisdomexchange.src.main.home.models

class WisdomExchange {
    lateinit var imgUrl: String
    var title: String
    var myWisdom: String
    var hopeWisdom: String
    var myWisdomItems: ArrayList<String>
    var hopeWisdomItems: ArrayList<String>
    var rate: Double
    var viewCount: Int
    var favoriteCount: Int

    constructor(
        title: String,
        myWisdom: String,
        hopeWisdom: String,
        myWisdomItems: ArrayList<String>,
        hopeWisdomItems: ArrayList<String>,
        rate: Double,
        viewCount: Int,
        favoriteCount: Int
    ) {
        this.title = title
        this.myWisdom = myWisdom
        this.hopeWisdom = hopeWisdom
        this.myWisdomItems = myWisdomItems
        this.hopeWisdomItems = hopeWisdomItems
        this.rate = rate
        this.viewCount = viewCount
        this.favoriteCount = favoriteCount
    }
}
