package com.devchernikova.firstapp


import androidx.recyclerview.widget.RecyclerView
import com.devchernikova.firstapp.databinding.FilmItemBinding



        class FilmViewHolder(val filmItemBinding: FilmItemBinding) : RecyclerView.ViewHolder(filmItemBinding.root) {


            private val title = filmItemBinding.title
            private val poster = filmItemBinding.poster
            private val description = filmItemBinding.description


            fun bind(film: Film) {
            //Устанавливаем заголо вок
                filmItemBinding.title.text = film.title
            //Устанавливаем постер
                filmItemBinding.poster.setImageResource(film.poster)
            //Устанавливаем описание
                filmItemBinding.description.text = film.description
    }
}






