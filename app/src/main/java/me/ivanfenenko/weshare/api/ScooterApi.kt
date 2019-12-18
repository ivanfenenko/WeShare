package me.ivanfenenko.weshare.api

import io.reactivex.Single
import me.ivanfenenko.weshare.model.ScootersResponse
import retrofit2.http.GET

interface ScooterApi {

    @GET("https://api.myjson.com/bins/1ed69g")
    fun getScooters(): Single<ScootersResponse>

}
