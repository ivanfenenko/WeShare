package me.ivanfenenko.weshare.model

import com.google.android.gms.maps.model.LatLng
import com.google.gson.annotations.SerializedName

data class ScooterLocation(
    @SerializedName("lng") val lng: Double,
    @SerializedName("lat") val lat: Double
) {

    fun toLatLng() = LatLng(lat, lng)

}
