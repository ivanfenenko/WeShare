package me.ivanfenenko.weshare.di

import dagger.Binds
import dagger.Module
import me.ivanfenenko.weshare.repository.ScooterRepository
import me.ivanfenenko.weshare.repository.ScooterRepositoryImpl
import me.ivanfenenko.weshare.rx.SchedulerConfiguration
import me.ivanfenenko.weshare.rx.SchedulerConfigurationImpl
import me.ivanfenenko.weshare.usecase.getscooters.GetScootersUseCase
import me.ivanfenenko.weshare.usecase.getscooters.GetScootersUseCaseImpl

@Module
interface BindingModule {

    @Binds
    fun bindsGetScootersUseCase(useCase: GetScootersUseCaseImpl): GetScootersUseCase


    @Binds
    fun bindsScooterRepository(useCase: ScooterRepositoryImpl): ScooterRepository

    @Binds
    fun bindsSchedulerConfiguration(schedulerConfiguration: SchedulerConfigurationImpl): SchedulerConfiguration

}
