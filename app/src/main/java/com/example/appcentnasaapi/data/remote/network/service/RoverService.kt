package com.example.appcentnasaapi.data.remote.network.service

import com.example.appcentnasaapi.domain.model.RoverPhotoRequestModel
import com.example.appcentnasaapi.domain.model.roverResponse.RoverResponse
import com.skydoves.sandwich.ApiResponse
import retrofit2.http.Body
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
    ) : ApiResponse<RoverResponse>

    @GET("rovers/opportunity/photos")
    suspend fun getOpportunityPhotos(
        @Query("sol") sol : String,
        @Query("camera") camera : String,
        @Query("api_key") apiKey : String,
        @Query("page") page : String
    ) : ApiResponse<RoverResponse>

    @GET("rovers/spirit/photos")
    suspend fun getSpiritPhotos(
        @Query("sol") sol : String,
        @Query("camera") camera : String,
        @Query("api_key") apiKey : String,
        @Query("page") page : String
    ) : ApiResponse<RoverResponse>

}