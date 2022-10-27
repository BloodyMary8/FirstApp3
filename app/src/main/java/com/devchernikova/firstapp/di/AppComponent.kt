package com.devchernikova.firstapp.di


import com.devchernikova.firstapp.di.modules.DatabaseModule
import com.devchernikova.firstapp.di.modules.DomainModule
import com.devchernikova.firstapp.di.modules.RemoteModule
import com.devchernikova.firstapp.viewmodel.HomeFragmentViewModel
import dagger.Component
import javax.inject.Singleton


@Singleton
@Component(
    //Внедряем все модули, нужные для этого компонента
    modules = [
        RemoteModule::class,    
        DatabaseModule::class,
        DomainModule::class
    ]
)
interface AppComponent {
    //метод для того, чтобы появилась внедрять зависимости в HomeFragmentViewModel
    fun inject(homeFragmentViewModel: HomeFragmentViewModel)
}