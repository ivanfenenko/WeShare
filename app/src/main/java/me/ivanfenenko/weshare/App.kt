package me.ivanfenenko.weshare

import android.app.Application
import me.ivanfenenko.weshare.di.ApplicationComponent
import me.ivanfenenko.weshare.di.DaggerApplicationComponent

class App : Application() {

    val component: ApplicationComponent by lazy {
        DaggerApplicationComponent.builder()
            .applicationContext(applicationContext)
            .build()
    }

    override fun onCreate() {
        super.onCreate()

        application = this
    }

    companion object {

        lateinit var application: App

    }

}
