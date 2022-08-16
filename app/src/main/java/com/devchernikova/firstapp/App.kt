package com.devchernikova.firstapp

import android.app.Application
import com.devchernikova.firstapp.di.AppComponent
import com.devchernikova.firstapp.di.DaggerAppComponent


class App : Application() {
    lateinit var dagger: AppComponent

    override fun onCreate() {
        super.onCreate()
        instance = this
        //Создаем компонент
        dagger = DaggerAppComponent.create()
    }

    companion object {
        lateinit var instance: App
            private set
    }
}