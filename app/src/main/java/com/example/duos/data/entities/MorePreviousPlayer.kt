package com.example.duos.data.entities

data class MorePreviousPlayer(


    val morePreviousProfileImg: Int? =null,
    val morePreviousProfileNickname: String = "",
    val morePreviousTimeOfGame : String = ""        // 경기한 시각. -> 나중에 Int로서 코틀린 | 안드로이드 스튜디오의 날짜 관련 라이브러리를 이용해 만들 수도


)
