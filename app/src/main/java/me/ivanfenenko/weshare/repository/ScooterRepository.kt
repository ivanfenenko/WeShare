package me.ivanfenenko.weshare.repository

import io.reactivex.Single
import me.ivanfenenko.weshare.model.Scooter

interface ScooterRepository {

    fun loadScooters(): Single<List<Scooter>>

}
