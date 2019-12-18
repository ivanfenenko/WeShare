package me.ivanfenenko.weshare.rx

import io.reactivex.Scheduler
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import me.ivanfenenko.weshare.rx.SchedulerConfiguration
import javax.inject.Inject

class SchedulerConfigurationImpl @Inject constructor() : SchedulerConfiguration {

    override fun io(): Scheduler = Schedulers.io()

    override fun ui(): Scheduler = AndroidSchedulers.mainThread()

}
