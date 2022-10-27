package com.devchernikova.firstapp.data


import com.devchernikova.firstapp.data.dao.FilmDao
import com.devchernikova.firstapp.data.entity.Film
import io.reactivex.rxjava3.core.Observable
import kotlinx.coroutines.flow.Flow


class MainRepository(private val filmDao: FilmDao) {

    fun putToDb(films: List<Film>) {
        filmDao.insertAll(films)
    }

    fun getAllFromDB(): Observable<List<Film>> = filmDao.getCachedFilms()
}