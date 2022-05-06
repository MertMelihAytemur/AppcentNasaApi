package com.example.appcentnasaapi.network.service

import com.example.appcentnasaapi.model.roverResponse.RoverResponse
import retrofit2.http.GET
import retrofit2.http.Query

/**
 *Created by Mert Melih Aytemur on 30.04.2022.
 */
interface RoverService {

    @GET("rovers/curiosity/photos")
    suspend fun getCuriosityPhotos(
        @Query("sol") sol : String,
        @Query("camera") camera : String,
        @Query("api_key") apiKey : String,
        @Query("page") page : String
    ) : RoverResponse

    @GET("rovers/opportunity/photos")
    suspend fun getOpportunityPhotos(
        @Query("sol") sol : String,
        @Query("camera") camera : String,
        @Query("api_key") apiKey : String,
        @Query("page") page : String
    ) : RoverResponse

    @GET("rovers/spirit/photos")
    suspend fun getSpiritPhotos(
        @Query("sol") sol : String,
        @Query("camera") camera : String,
        @Query("api_key") apiKey : String,
        @Query("page") page : String
    ) : RoverResponse

}