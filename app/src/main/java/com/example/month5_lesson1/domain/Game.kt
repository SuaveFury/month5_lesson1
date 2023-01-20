package com.example.month5_lesson1.domain



class Game<content>(private val list: List<Int>) {

    private val cards:ArrayList<Card<content>> = ArrayList()

    init {
        list.forEachIndexed { index, content ->
            cards.add(Card(id = index*index, content =content))
            cards.add(Card(id = index*index + 2 , content =content))
        }
    }
    fun getCards() = cards

    fun onCardClick(card: Card<content>){
        card.isFacedUp = !card.isFacedUp

        if (card.isFacedUp)
            cards.forEach {
                if (card.id != it.id && card.content == it.content && it.isFacedUp){
                    cards[cards.indexOf(card)].isMatched = true
                    it.isMatched = true

                }
                else{
                    it.isFacedUp = false
                    cards[cards.indexOf(card)].isFacedUp = false

                }
            }
    }
}



}
