package com.devchernikova.firstapp

import kotlinx.android.parcel.Parcelize
import android.os.Parcelable


@Parcelize
data class Film(
    val poster: Int,
    val title: String,
    val description: String,
    var rating: Float = 0f,
    var isInFavorites: Boolean = false
) : android.os.Parcelable