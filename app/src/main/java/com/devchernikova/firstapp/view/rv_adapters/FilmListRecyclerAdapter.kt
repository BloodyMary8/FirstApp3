package com.devchernikova.firstapp.view.rv_adapters



import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.devchernikova.firstapp.view.rv_viewholders.FilmViewHolder
import com.devchernikova.firstapp.databinding.FilmItemBinding
import com.devchernikova.firstapp.data.entity.Film


class FilmListRecyclerAdapter(private val clickListener: OnItemClickListener) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    //Здесь у нас хранится список элементов для RV
    val items = mutableListOf<Film>()

    //Этот метод нужно переопределить на возврат количества елементов в списке RV
    override fun getItemCount() = items.size

    //В этом методе мы привязываем наш view holder и передаем туда "надутую" верстку нашего фильма
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FilmViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val filmItemBinding = FilmItemBinding.inflate(layoutInflater, parent, false)
        return FilmViewHolder(filmItemBinding)
    }

    //В этом методе будет привзяка полей из объекта Film, к view из film_item.xml
    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int){
        //Проверяем какой у нас ViewHolder
        when (holder) {
            is FilmViewHolder -> {
                //Вызываем метод bind(), который мы создали и передаем туда объект
                //из нашей базы данных с указанием позиции
                holder.bind(items[position])
                //Обрабатываем нажатие на весь элемент целиком(можно сделать на отдельный элемент
                //напрмер, картинку) и вызываем метод нашего листенера, который мы получаем из
                //конструктора адаптера
                holder.filmItemBinding.itemContainer.setOnClickListener { clickListener.click(items[position]) }
            }
        }
    }

    //Метод для добавления объектов в наш список
    fun addItems(list: List<Film>) {
        //Сначала очишаем(если не реализовать DiffUtils)
        items.clear()
        //Добавляем
        items.addAll(list)
        //Уведомляем RV, что пришел новый список и ему нужно заново все "привязывать"
        notifyDataSetChanged()
    }

    //Интерфейс для обработки кликов
    interface OnItemClickListener {
        fun click(film: Film)
    }
}