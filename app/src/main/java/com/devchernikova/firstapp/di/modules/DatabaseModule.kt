package com.devchernikova.firstapp.di.modules

import com.devchernikova.firstapp.data.MainRepository
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
internal class DatabaseModule {
    @Provides
    @Singleton
    fun provideRepository()= MainRepository()
}