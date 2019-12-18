package me.ivanfenenko.weshare.di

import android.content.Context
import dagger.BindsInstance
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [BindingModule::class, ProvidingModule::class, ViewModelModule::class])
interface ApplicationComponent {

    @Component.Builder
    interface Builder {

        @BindsInstance
        fun applicationContext(applicationContext: Context): Builder

        fun build(): ApplicationComponent

    }

    fun viewModelFactory(): ViewModelFactory

}
