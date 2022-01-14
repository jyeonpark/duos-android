package com.example.duos.data.entities

data class Review(

    val profileImg: Int? =null,
    val playerGrade: String= "",
    val profileNickname: String = "",
    val review_content_tv: String = "",
    // 별 개수를 어떻게 할지???? 배열을 사용해서 인덱스 0 부터 4로 별의 값을 줘야 하나?
    // 평점이 만약 3.3이거나 2.2처럼 소수 첫번째 자리수가 간단하지 않을 경우??
    // 일단은 별들을 고정된 데이터라고 해두고 상의해보자.

)
