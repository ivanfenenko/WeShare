package me.ivanfenenko.weshare

import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleObserver
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.OnLifecycleEvent
import androidx.lifecycle.ViewModel
import io.reactivex.disposables.CompositeDisposable
import me.ivanfenenko.weshare.model.Scooter
import me.ivanfenenko.weshare.rx.SchedulerConfiguration
import me.ivanfenenko.weshare.usecase.getscooters.GetScootersUseCase
import javax.inject.Inject

class MapViewModel @Inject constructor(
    private val getScootersUseCase: GetScootersUseCase,
    private val schedulerConfiguration: SchedulerConfiguration
) : ViewModel(), LifecycleObserver {

    private var compositeDisposable: CompositeDisposable? = null

    private val scooters: MutableLiveData<List<Scooter>> = MutableLiveData()

    fun getScooters() = scooters

    @OnLifecycleEvent(Lifecycle.Event.ON_START)
    fun onViewAttached() {
        compositeDisposable = CompositeDisposable()

        loadScooters()
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_STOP)
    fun onViewDetached() {
        compositeDisposable?.dispose()
        compositeDisposable = null
    }

    private fun loadScooters() {
        getScootersUseCase.execute()
            .subscribeOn(schedulerConfiguration.io())
            .observeOn(schedulerConfiguration.ui())
            .subscribe({
                scooters.postValue(it)
            }, {
                // Not implemented
            })
            .also { compositeDisposable?.add(it) }
    }

}
