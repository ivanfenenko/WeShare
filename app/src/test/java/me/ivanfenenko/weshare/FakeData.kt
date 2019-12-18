package me.ivanfenenko.weshare

import me.ivanfenenko.weshare.model.Scooter
import me.ivanfenenko.weshare.model.ScooterLocation

fun fakeScooters() = listOf(
    fakeScooter(),
    fakeScooter(),
    fakeScooter(),
    fakeScooter(),
    fakeScooter()
)

fun fakeScooter() = Scooter("", "", "", 0, ScooterLocation(0.0, 0.0), 0.0, "", "")
