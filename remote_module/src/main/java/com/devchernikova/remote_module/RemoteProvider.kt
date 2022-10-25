package com.devchernikova.remote_module

interface RemoteProvider {
    fun provideRemote(): TmdbApi
}