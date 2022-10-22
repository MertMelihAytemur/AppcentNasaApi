package com.example.appcentnasaapi.data.repository

import com.example.appcentnasaapi.di.IoDispatcher
import com.example.appcentnasaapi.data.remote.network.service.RoverService
import com.example.appcentnasaapi.domain.model.RoverPhotoRequestModel
import com.example.appcentnasaapi.core.base.BaseRepository
import javax.inject.Inject
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.flow.flowOn

/**
 *Created by Mert Melih Aytemur on 30.04.2022.
 */
class RoverRepository @Inject constructor(
    private val roverService: RoverService,
    @IoDispatcher private val ioScope : CoroutineDispatcher
    ) : BaseRepository() {

    suspend fun getCuriosityPhotos(
        roverPhotoRequestModel: RoverPhotoRequestModel
    ) = invoke {
        roverService.getCuriosityPhotos(
            roverPhotoRequestModel.sol,
            roverPhotoRequestModel.camera,
            roverPhotoRequestModel.apiKey,
            roverPhotoRequestModel.page
        )
    }.flowOn(ioScope)

    suspend fun getOpportunityPhotos(
        roverPhotoRequestModel: RoverPhotoRequestModel
    ) = invoke {
        roverService.getOpportunityPhotos(
            roverPhotoRequestModel.sol,
            roverPhotoRequestModel.camera,
            roverPhotoRequestModel.apiKey,
            roverPhotoRequestModel.page
        )
    }.flowOn(ioScope)

    suspend fun getSpiritPhotos(
        roverPhotoRequestModel: RoverPhotoRequestModel
    ) = invoke {
        roverService.getSpiritPhotos(
            roverPhotoRequestModel.sol,
            roverPhotoRequestModel.camera,
            roverPhotoRequestModel.apiKey,
            roverPhotoRequestModel.page
        )
    }.flowOn(ioScope)
}