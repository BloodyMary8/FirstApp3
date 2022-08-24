package com.devchernikova.firstapp

import android.app.Application
import com.devchernikova.firstapp.di.AppComponent
import com.devchernikova.firstapp.di.DaggerAppComponent
import com.devchernikova.firstapp.di.modules.DatabaseModule
import com.devchernikova.firstapp.di.modules.DomainModule
import com.devchernikova.firstapp.di.modules.RemoteModule


class App : Application() {
    lateinit var dagger: AppComponent

    override fun onCreate() {
        super.onCreate()
        instance = this
        //Создаем компонент
        dagger = DaggerAppComponent.builder()
            .remoteModule(RemoteModule())
            .databaseModule(DatabaseModule())
            .domainModule(DomainModule(this))
            .build()
    }

    companion object {
        lateinit var instance: App
            private set
    }
}