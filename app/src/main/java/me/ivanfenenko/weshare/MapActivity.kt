package me.ivanfenenko.weshare

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.model.LatLngBounds
import me.ivanfenenko.tier.runner.ui.ext.displayHeight
import me.ivanfenenko.tier.runner.ui.ext.displayWidth
import me.ivanfenenko.tier.runner.ui.ext.mapPadding
import me.ivanfenenko.weshare.ext.addMarker
import me.ivanfenenko.weshare.ext.getMapAsync
import me.ivanfenenko.weshare.model.Scooter

class MapActivity : AppCompatActivity(), OnMapReadyCallback {

    private val viewModel: MapViewModel by lazy {
        ViewModelProviders.of(this, component().viewModelFactory())[MapViewModel::class.java]
    }
    private lateinit var googleMap: GoogleMap

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        getMapAsync(this)
    }

    override fun onMapReady(googleMap: GoogleMap) {
        this.googleMap = googleMap

        viewModel.getScooters().observe(this, Observer { scooters ->
            scooters.forEach { scooter ->
                this.googleMap.addMarker(scooter)
            }
            zoomOnPosition(scooters)
        })
    }

    private fun zoomOnPosition(scooters: List<Scooter>) {
        val builder = LatLngBounds.Builder()
        scooters.forEach {
            builder.include(it.location.toLatLng())
        }
        val cameraUpdate = CameraUpdateFactory.newLatLngBounds(
            builder.build(), displayWidth(), displayHeight(), mapPadding()
        )
        this.googleMap.animateCamera(cameraUpdate)
    }

}
