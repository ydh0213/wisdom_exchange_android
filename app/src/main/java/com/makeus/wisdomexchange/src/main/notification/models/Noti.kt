package com.makeus.wisdomexchange.src.main.notification.models

class Noti(
    var exchange_id: Int, // 교환 요청 id
    var sender_id: Int, // 발신자 user id
    var receiver_id: Int, // 수신자 user id
    var updateTime: String, // 발신 시간
    var isExchanged: Int, // 교환 수락 되었는지 여부
    var opponent_nick: String, // 상대방의 닉네임
    var profile_img: String?, // 상대방의 프로필 사진 없으면 null, url
    var opponent_resume_id: Int, // 상대방 교환서 id
    var phone: String?, // 상대방 전화번호, isExchanged = 0이면 null return
    var isSender: Int // 1, 0 수신한 교환요청인지, 보낸건지
)
