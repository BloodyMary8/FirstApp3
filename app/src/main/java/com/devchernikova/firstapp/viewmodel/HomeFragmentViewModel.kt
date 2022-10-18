package com.devchernikova.firstapp.viewmodel



import androidx.lifecycle.ViewModel
import com.devchernikova.firstapp.App
import com.devchernikova.firstapp.data.entity.Film
import com.devchernikova.firstapp.domain.Interactor
import io.reactivex.rxjava3.core.Observable
import io.reactivex.rxjava3.subjects.BehaviorSubject
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class HomeFragmentViewModel : ViewModel() {
    //Инициализируем интерактор
    @Inject
    lateinit var interactor: Interactor
    val filmsListData: Observable<List<Film>>
    val showProgressBar: BehaviorSubject<Boolean>

    init {
        App.instance.dagger.inject(this)
        showProgressBar = interactor.progressBarState
        filmsListData = interactor.getFilmsFromDB()
        getFilms()
    }
    fun getSearchResult(search: String) = interactor.getSearchResultFromApi(search)
    
    fun getFilms() {
        interactor.getFilmsFromApi(1)
    }
}