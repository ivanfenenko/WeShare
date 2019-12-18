package me.ivanfenenko.weshare.repository

import io.reactivex.Single
import me.ivanfenenko.weshare.api.ScooterApi
import me.ivanfenenko.weshare.model.Scooter
import javax.inject.Inject

class ScooterRepositoryImpl @Inject constructor(
    private val scooterApi: ScooterApi
) : ScooterRepository {

    override fun loadScooters(): Single<List<Scooter>> {
        return scooterApi.getScooters().map { it.scooters }
    }

}
