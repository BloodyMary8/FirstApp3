package com.devchernikova.firstapp.view.rv_viewholders


import androidx.recyclerview.widget.RecyclerView
import com.devchernikova.firstapp.databinding.FilmItemBinding
import com.bumptech.glide.Glide
import com.devchernikova.firstapp.data.ApiConstants
import com.devchernikova.firstapp.domain.Film


class FilmViewHolder(val filmItemBinding: FilmItemBinding) : RecyclerView.ViewHolder(filmItemBinding.root) {

            private val title = filmItemBinding.title
            private val poster = filmItemBinding.poster
            private val description = filmItemBinding.description

            fun bind(film: Film) {
                //Устанавливаем заголовок
                title.text = film.title
                //Устанавливаем постер
                //Указываем контейнер, в которм будет "жить" наша картинка
              Glide.with(itemView)
                    //Загружаем сам ресурс
                  .load(ApiConstants.IMAGES_URL + "w342" + film.poster)
                    //Центруем изображение
                    .centerCrop()
                    //Указываем ImageView, куда будем загружать изображение
                    .into(poster)
                //Устанавливаем описание
                description.text = film.description
                filmItemBinding.ratingDonut.setProgress((film.rating * 10).toInt())
            }
        }







