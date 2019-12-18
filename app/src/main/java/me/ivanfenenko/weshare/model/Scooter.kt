package me.ivanfenenko.weshare.model

import com.google.gson.annotations.SerializedName

data class Scooter(
    @SerializedName("id") val id: String,
    @SerializedName("vin") val vin: String,
    @SerializedName("license_plate") val licensePlate: String,
    @SerializedName("energy_level") val energyLevel: Int,
    @SerializedName("location") val location: ScooterLocation,
    @SerializedName("distance_to_travel") val distanceToTravel: Double,
    @SerializedName("market_id") var marketId: String,
    @SerializedName("model") val model: String
)
