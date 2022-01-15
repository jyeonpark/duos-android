package com.example.duos.data.entities

data class RecommendedPartner(
    var profileImg: Int? = null,
    var location: String = "",
    var ballCapacity: String = "",
    var id: String = "",
    var age: String = "",
    var starRating: Double = 0.0,
    var reviewCount: Int = 0
)
