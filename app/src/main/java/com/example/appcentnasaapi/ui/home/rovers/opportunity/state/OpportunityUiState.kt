package com.example.appcentnasaapi.ui.home.rovers.opportunity.state

import com.example.appcentnasaapi.domain.model.RoverPhotoRequestModel
import com.example.appcentnasaapi.domain.model.roverResponse.RoverResponse

/**
 *Created by Mert Melih Aytemur on 22.10.2022.
 */
sealed interface OpportunityUiState {
    data class Success(val data: RoverResponse) : OpportunityUiState
    object Loading : OpportunityUiState
    data class Error(val error: Throwable) : OpportunityUiState
    object Empty : OpportunityUiState
}