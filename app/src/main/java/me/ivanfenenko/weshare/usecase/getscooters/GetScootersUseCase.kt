package me.ivanfenenko.weshare.usecase.getscooters

import me.ivanfenenko.weshare.model.Scooter
import me.ivanfenenko.weshare.usecase.ObservableUseCaseNoParams

interface GetScootersUseCase : ObservableUseCaseNoParams<List<Scooter>>
