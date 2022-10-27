package com.devchernikova.firstapp.utils

import com.devchernikova.firstapp.data.entity.TmdbFilm
import com.devchernikova.firstapp.domain.Film

object Converter {
    @JvmStatic
    fun convertApiListToDtoList(list: List<TmdbFilm>?): List<Film> {
        val result = mutableListOf<Film>()
        list?.forEach {
            result.add(Film(
                title = it.title,
                poster = it.posterPath,
                description = it.overview,
                rating = it.voteAverage,
                isInFavorites = false
            ))
        }
        return result
    }
}