package me.ivanfenenko.weshare.usecase.getscooters

import io.reactivex.Observable
import me.ivanfenenko.weshare.model.Scooter
import me.ivanfenenko.weshare.repository.ScooterRepository
import java.util.concurrent.TimeUnit
import javax.inject.Inject

class GetScootersUseCaseImpl @Inject constructor(
    private val repository: ScooterRepository
) : GetScootersUseCase {

    override fun execute(): Observable<List<Scooter>> {
        return Observable.interval(5, TimeUnit.SECONDS)
            .switchMapSingle {
                repository.loadScooters()
            }
    }
}
