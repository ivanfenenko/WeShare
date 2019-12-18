package me.ivanfenenko.weshare.rx

import io.reactivex.Scheduler

interface SchedulerConfiguration {

    fun io(): Scheduler

    fun ui(): Scheduler

}
