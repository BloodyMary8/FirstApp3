package com.devchernikova.firstapp.domain

import com.devchernikova.firstapp.data.MainRepository

class Interactor(val repo: MainRepository) {
    fun getFilmsDB(): List<Film> = repo.filmsDataBase
}