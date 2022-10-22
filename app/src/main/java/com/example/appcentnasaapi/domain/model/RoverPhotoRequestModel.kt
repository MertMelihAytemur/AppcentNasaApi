package com.example.appcentnasaapi.domain.model

/**
 *Created by Mert Melih Aytemur on 22.10.2022.
 */
data class RoverPhotoRequestModel(
    val sol : String,
    val camera : String,
    val apiKey : String,
    val page : String
)
