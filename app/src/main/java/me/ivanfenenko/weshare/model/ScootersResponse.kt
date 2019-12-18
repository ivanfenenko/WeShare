package me.ivanfenenko.weshare.model

import com.google.gson.annotations.SerializedName

data class ScootersResponse(
    @SerializedName("scooters") val scooters: List<Scooter>
)
