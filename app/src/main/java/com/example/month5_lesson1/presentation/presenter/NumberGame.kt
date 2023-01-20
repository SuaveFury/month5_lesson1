package com.example.month5_lesson1.presentation.presenter

import com.example.month5_lesson1.domain.Card
import com.example.month5_lesson1.domain.Game

class NumberGame {
    private val game = Game<Int>(
        listOf(
      1 ,2 ,3 ,4 ,5 ,6
    ))
    fun getCards() = game.getCards()

    fun onCardClick(card: Card<Int>){
        game.onCardClick(card)

    }
}