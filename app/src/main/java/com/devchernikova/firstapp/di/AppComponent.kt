package com.devchernikova.firstapp.di


import com.devchernikova.firstapp.di.modules.DatabaseModule
import com.devchernikova.firstapp.di.modules.DomainModule
import com.devchernikova.firstapp.viewmodel.HomeFragmentViewModel
import com.devchernikova.firstapp.viewmodel.SettingsFragmentViewModel
import com.devchernikova.remote_module.RemoteProvider
import dagger.Component
import javax.inject.Singleton


@Singleton
@Component(
    //Внедряем все модули, нужные для этого компонента
    dependencies = [RemoteProvider::class],
    modules = [
        DatabaseModule::class,
        DomainModule::class
    ]
)
interface AppComponent {
    //метод для того, чтобы появилась возможность внедрять зависимости в HomeFragmentViewModel
    fun inject(homeFragmentViewModel: HomeFragmentViewModel)
    //метод для того, чтобы появилась возможность внедрять зависимости в SettingsFragmentViewModel
    fun inject(settingsFragmentViewModel: SettingsFragmentViewModel)

}