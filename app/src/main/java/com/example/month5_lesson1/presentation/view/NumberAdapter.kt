package com.example.month5_lesson1.presentation.view

import android.os.Looper
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.month5_lesson1.R
import com.example.month5_lesson1.databinding.ItemNumberBinding
import com.example.month5_lesson1.domain.Card
import com.example.month5_lesson1.presentation.presenter.NumberGame


class NumberAdapter : RecyclerView.Adapter<NumberAdapter.ViewHolder>() {
    private val numberGame = NumberGame()

   inner class ViewHolder(itemView : View) : RecyclerView.ViewHolder(itemView){

        private val  ui = ItemNumberBinding.bind(itemView)

        fun onBind(card: Card<Int>){
            if (card.isMatched) onUiUpdate(card, true)
            else onUiUpdate(card,card.isFacedUp)

            if (!card.isMatched)
            ui.itemFrame.setOnClickListener{
                onUiUpdate(card,!card.isMatched)

                numberGame.onCardClick(card)

              android.os.Handler(Looper.getMainLooper()).postDelayed({

              },1000)


            }

        }
     private fun onUiUpdate(card: Card<Int>, isFaced: Boolean){
            ui.itemTv.text = if (isFaced) card.content.toString()
            else ""
            ui.itemFrame.isPressed = isFaced
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.item_number, parent,false)
        )
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.onBind(numberGame.getCards()[position])
    }

    override fun getItemCount(): Int {
        return numberGame.getCards().size
    }
}