package com.devchernikova.firstapp.di.modules

import android.content.Context
import com.devchernikova.firstapp.data.DatabaseHelper
import com.devchernikova.firstapp.data.MainRepository
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class DatabaseModule {
    @Singleton
    @Provides
    fun provideDatabaseHelper(context: Context) = DatabaseHelper(context)

    @Provides
    @Singleton
    fun provideRepository(databaseHelper: DatabaseHelper) = MainRepository(databaseHelper)
}