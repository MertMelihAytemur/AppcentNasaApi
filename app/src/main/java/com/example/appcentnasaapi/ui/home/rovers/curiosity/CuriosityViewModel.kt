package com.example.appcentnasaapi.ui.home.rovers.curiosity


import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.appcentnasaapi.model.roverResponse.RoverResponse
import com.example.appcentnasaapi.repository.RoverRepository
import com.example.appcentnasaapi.util.Const.API_KEY
import com.example.appcentnasaapi.util.Const.SOL
import com.example.appcentnasaapi.util.network.NetworkResult
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

/**
 *Created by Mert Melih Aytemur on 30.04.2022.
 */
@HiltViewModel
class CuriosityViewModel @Inject constructor(private val roverRepository: RoverRepository) : ViewModel() {
    var roverResponse : MutableLiveData<RoverResponse>? = MutableLiveData()
    val isLoading : MutableLiveData<Boolean> = MutableLiveData()
    val onError : MutableLiveData<String?> = MutableLiveData()


    fun getCuriosityPhotos(
        camera: String,
        page : String
    ) = viewModelScope.launch {
        isLoading.value = true
        val request = roverRepository.getCuriosityPhotos(SOL,camera,API_KEY,page)
        when(request){
            is NetworkResult.Success -> {
                roverResponse?.value = request.data!!
                isLoading.value = false
            }
            is NetworkResult.Error -> {
                onError.value = request.message
                isLoading.value = false
            }
        }
    }

}