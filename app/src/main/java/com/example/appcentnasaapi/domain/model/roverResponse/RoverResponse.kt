package com.example.appcentnasaapi.domain.model.roverResponse


import com.google.gson.annotations.SerializedName

data class RoverResponse(
    @SerializedName("photos")
    val photos: MutableList<Photo>?
)