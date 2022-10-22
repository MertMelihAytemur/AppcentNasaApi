package com.example.appcentnasaapi.ui.home.rovers.spirit.state


import com.example.appcentnasaapi.domain.model.roverResponse.RoverResponse

/**
 *Created by Mert Melih Aytemur on 22.10.2022.
 */
sealed interface SpiritUiState {
    data class Success(val data: RoverResponse) : SpiritUiState
    object Loading : SpiritUiState
    data class Error(val error: Throwable) : SpiritUiState
    object Empty : SpiritUiState
}