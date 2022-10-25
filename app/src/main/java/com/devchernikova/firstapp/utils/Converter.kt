package com.devchernikova.firstapp.utils

import com.devchernikova.remote_module.entity.TmdbFilm
import com.devchernikova.firstapp.data.entity.Film

object Converter {
    @JvmStatic
    fun convertApiListToDtoList(list: List<com.devchernikova.remote_module.entity.TmdbFilm>?): List<Film> {
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