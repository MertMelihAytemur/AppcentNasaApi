package com.example.appcentnasaapi.repository

import com.example.appcentnasaapi.network.service.RoverService
import com.example.appcentnasaapi.util.base.BaseRepository
import javax.inject.Inject

/**
 *Created by Mert Melih Aytemur on 30.04.2022.
 */
class RoverRepository @Inject constructor(private val roverService: RoverService ) : BaseRepository() {
    suspend fun getCuriosityPhotos(
        sol : String,
        camera : String,
        apiKey : String,
        page : String
    ) = safeApiRequest {
        roverService.getCuriosityPhotos(sol,camera,apiKey,page)
    }

    suspend fun getOpportunityPhotos(
        sol : String,
        camera : String,
        apiKey : String,
        page : String
    ) = safeApiRequest {
        roverService.getOpportunityPhotos(sol,camera,apiKey,page)
    }

    suspend fun getSpiritPhotos(
        sol : String,
        camera : String,
        apiKey : String,
        page : String
    ) = safeApiRequest {
        roverService.getSpiritPhotos(sol,camera,apiKey,page)
    }
}