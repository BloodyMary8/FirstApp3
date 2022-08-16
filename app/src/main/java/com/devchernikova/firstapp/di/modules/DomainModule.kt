package com.devchernikova.firstapp.di.modules

import com.devchernikova.firstapp.data.MainRepository
import com.devchernikova.firstapp.data.TmdbApi
import com.devchernikova.firstapp.domain.Interactor
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class DomainModule {
    @Singleton
    @Provides
    fun provideInteractor(repository: MainRepository, tmdbApi: TmdbApi) = Interactor(repo = repository, retrofitService = tmdbApi)
}