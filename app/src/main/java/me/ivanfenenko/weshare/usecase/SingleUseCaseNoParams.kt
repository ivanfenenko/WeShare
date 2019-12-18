package me.ivanfenenko.weshare.usecase

import io.reactivex.Observable

interface ObservableUseCaseNoParams<Result> {
    fun execute(): Observable<Result>
}
