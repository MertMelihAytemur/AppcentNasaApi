package com.example.appcentnasaapi.ui.home.rovers.curiosity.state

import com.example.appcentnasaapi.domain.model.RoverPhotoRequestModel
import com.example.appcentnasaapi.domain.model.roverResponse.RoverResponse

/**
 *Created by Mert Melih Aytemur on 22.10.2022.
 */
sealed interface CuriosityUiState {
    data class Success(val data: RoverResponse) : CuriosityUiState
    object Loading : CuriosityUiState
    data class Error(val error: Throwable) : CuriosityUiState
    object Empty : CuriosityUiState
}