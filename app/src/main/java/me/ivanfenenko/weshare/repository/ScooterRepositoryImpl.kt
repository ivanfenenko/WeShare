package me.ivanfenenko.weshare.repository

import io.reactivex.Single
import me.ivanfenenko.weshare.model.Scooter
import javax.inject.Inject

class ScooterRepositoryImpl @Inject constructor() : ScooterRepository {

    override fun loadScooters(): Single<List<Scooter>> {
        return Single.just(emptyList())
    }

}
