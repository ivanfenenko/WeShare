package me.ivanfenenko.tier.runner.ui.ext

import android.app.Activity

fun Activity.displayWidth() = resources.displayMetrics.widthPixels

fun Activity.displayHeight() = resources.displayMetrics.heightPixels

fun Activity.mapPadding(): Int {
    val width = resources.displayMetrics.widthPixels
    return (width * 0.10).toInt()
}
