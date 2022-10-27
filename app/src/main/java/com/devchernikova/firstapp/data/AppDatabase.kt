package com.devchernikova.firstapp.data

import androidx.room.Database
import androidx.room.RoomDatabase
import com.devchernikova.firstapp.data.dao.FilmDao
import com.devchernikova.firstapp.data.entity.Film

@Database(entities = [Film::class], version = 1, exportSchema = false)
abstract class AppDatabase : RoomDatabase() {
    abstract fun filmDao(): FilmDao
}