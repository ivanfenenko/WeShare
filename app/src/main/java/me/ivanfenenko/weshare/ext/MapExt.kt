package me.ivanfenenko.weshare.ext

import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.BitmapDescriptor
import com.google.android.gms.maps.model.BitmapDescriptorFactory
import com.google.android.gms.maps.model.MarkerOptions
import me.ivanfenenko.weshare.MapActivity
import me.ivanfenenko.weshare.R
import me.ivanfenenko.weshare.model.Scooter

fun MapActivity.getMapAsync(callback: OnMapReadyCallback) {
    (supportFragmentManager.findFragmentById(R.id.map) as SupportMapFragment).getMapAsync(callback)
}

fun markerIcon(): BitmapDescriptor = BitmapDescriptorFactory.fromResource(R.drawable.ic_scooter_marker)

fun GoogleMap.addMarker(scooter: Scooter) {
    this.addMarker(MarkerOptions().position(scooter.location.toLatLng()).icon(markerIcon())).apply {
        tag = scooter
    }
}
