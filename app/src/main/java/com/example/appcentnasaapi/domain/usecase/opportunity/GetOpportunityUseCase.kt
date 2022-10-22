package com.example.appcentnasaapi.domain.usecase.opportunity

import com.example.appcentnasaapi.data.repository.RoverRepository
import com.example.appcentnasaapi.domain.model.RoverPhotoRequestModel
import com.example.appcentnasaapi.domain.model.roverResponse.RoverResponse
import javax.inject.Inject
import kotlinx.coroutines.flow.Flow

/**
 *Created by Mert Melih Aytemur on 22.10.2022.
 */
class GetOpportunityUseCase @Inject constructor(
    private val roverRepository: RoverRepository
) : IGetOpportunityPhotosUseCase {
    override suspend fun getOpportunityPhotos(roverPhotoRequestModel: RoverPhotoRequestModel): Flow<Result<RoverResponse>> {
        return roverRepository.getOpportunityPhotos(roverPhotoRequestModel)
    }
}