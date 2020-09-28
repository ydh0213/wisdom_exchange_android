package com.makeus.wisdomexchange.src.main.home.models

class WisdomExchange {
    lateinit var imgUrl: String
    var title: String
    var myWisdom: String
    var wantWisdom: String

    constructor(title: String, myWisdom: String, wantWisdom: String) {
        this.title = title
        this.myWisdom = myWisdom
        this.wantWisdom = wantWisdom
    }
}
