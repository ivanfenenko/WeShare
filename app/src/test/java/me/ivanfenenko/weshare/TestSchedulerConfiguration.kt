package me.ivanfenenko.weshare

import io.reactivex.Scheduler
import io.reactivex.schedulers.Schedulers
import me.ivanfenenko.weshare.rx.SchedulerConfiguration

class TestSchedulerConfiguration : SchedulerConfiguration {

    override fun io(): Scheduler = Schedulers.trampoline()

    override fun ui(): Scheduler = Schedulers.trampoline()

}
