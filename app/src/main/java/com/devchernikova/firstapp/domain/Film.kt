package com.devchernikova.firstapp.domain

import kotlinx.android.parcel.Parcelize
import android.os.Parcelable


@Parcelize
data class Film(
    val title: String,
    val poster: String, //У нас будет приходить ссылка на картинку, так что теперь это String
    val description: String,
    var rating: Double = 0.0, //Приходит не целое число с API
    var isInFavorites: Boolean = false
) : Parcelable