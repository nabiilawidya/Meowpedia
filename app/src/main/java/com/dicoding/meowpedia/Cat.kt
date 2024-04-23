package com.dicoding.meowpedia

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Cat(
    val name: String,
    val description: String,
    val photo: Int
) : Parcelable {

}