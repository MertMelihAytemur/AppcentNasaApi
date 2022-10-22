package com.example.appcentnasaapi.domain.usecase.curiosity

import com.example.appcentnasaapi.domain.model.RoverPhotoRequestModel
import com.example.appcentnasaapi.domain.model.roverResponse.RoverResponse
import kotlinx.coroutines.flow.Flow


/**
 *Created by Mert Melih Aytemur on 22.10.2022.
 */
interface IGetCuriosityPhotosUseCase {
    suspend fun getCuriosityPhotos(roverPhotoRequestModel: RoverPhotoRequestModel) : Flow<Result<RoverResponse>>
}