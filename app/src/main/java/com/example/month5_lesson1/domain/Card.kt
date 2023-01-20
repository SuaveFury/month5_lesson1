package com.example.month5_lesson1.domain

data class Card<Content>(
    val id:Int,
    var  isFacedUp:Boolean = false,
    var isMatched:Boolean = false,
    var content: Content

)
