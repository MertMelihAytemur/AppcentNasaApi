package com.example.appcentnasaapi.ui.home.rovers.curiosity


import androidx.lifecycle.viewModelScope
import com.example.appcentnasaapi.domain.model.RoverPhotoRequestModel
import com.example.appcentnasaapi.domain.usecase.curiosity.IGetCuriosityPhotosUseCase
import com.example.appcentnasaapi.ui.home.rovers.curiosity.state.CuriosityUiState
import com.example.appcentnasaapi.core.Const.API_KEY
import com.example.appcentnasaapi.core.Const.SOL
import com.example.appcentnasaapi.core.base.BaseViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.update

/**
 *Created by Mert Melih Aytemur on 30.04.2022.
 */
@HiltViewModel
class CuriosityViewModel @Inject constructor(
    private val getCuriosityPhotosUseCase: IGetCuriosityPhotosUseCase
) : BaseViewModel() {
    private val _curiosityUiState = MutableStateFlow<CuriosityUiState>(CuriosityUiState.Empty)
    val curiosityUiState : StateFlow<CuriosityUiState> = _curiosityUiState

    private var roverPhotoRequestModel : RoverPhotoRequestModel

    init {
        // Initial values
        roverPhotoRequestModel = RoverPhotoRequestModel(
            sol = SOL,
            camera = "fhaz",
            apiKey = API_KEY,
            page = "1"
        )
        getCuriosityPhotos()
    }

   private fun getCuriosityPhotos(){
        viewModelScope.launch {
            invokeUseCase(
                getCuriosityPhotosUseCase.getCuriosityPhotos(roverPhotoRequestModel),
                onSuccess = { roverPhotos ->
                    updateUiState(CuriosityUiState.Success(roverPhotos))
                },
                onError = {throwable ->
                    _curiosityUiState.update {
                        CuriosityUiState.Error(throwable)
                    }
                }
            )

        }
    }

    private fun updateUiState(result: CuriosityUiState){
        _curiosityUiState.update {
            when(result){
                is CuriosityUiState.Success -> CuriosityUiState.Success(result.data)
                is CuriosityUiState.Error -> CuriosityUiState.Error(result.error)
                else -> CuriosityUiState.Error(UnknownError())
            }
        }
    }

    fun clearUiState() {
        _curiosityUiState.update {
            CuriosityUiState.Empty
        }
    }

    fun setCamera(camera : CharSequence?){
        roverPhotoRequestModel = roverPhotoRequestModel.copy(camera = camera.toString())
    }

    fun setPage(page : CharSequence?){
        roverPhotoRequestModel = roverPhotoRequestModel.copy(page = page.toString())
    }

}