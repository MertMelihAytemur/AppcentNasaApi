package com.example.appcentnasaapi.domain.usecase.spirit

import com.example.appcentnasaapi.domain.model.RoverPhotoRequestModel
import com.example.appcentnasaapi.domain.model.roverResponse.RoverResponse
import kotlinx.coroutines.flow.Flow

/**
 *Created by Mert Melih Aytemur on 22.10.2022.
 */
interface IGetSpiritPhotosUseCase {
    suspend fun getSpiritPhotos(roverPhotoRequestModel: RoverPhotoRequestModel) : Flow<Result<RoverResponse>>
}