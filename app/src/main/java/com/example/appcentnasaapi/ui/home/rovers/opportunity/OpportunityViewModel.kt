package com.example.appcentnasaapi.ui.home.rovers.opportunity

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
class OpportunityViewModel @Inject constructor(private val roverRepository: RoverRepository) : ViewModel() {
    val roverResponse : MutableLiveData<RoverResponse> = MutableLiveData()
    val isLoading : MutableLiveData<Boolean> = MutableLiveData()
    val onError : MutableLiveData<String?> = MutableLiveData()


    fun getOpportunityPhotos(
        camera : String,
        page : String
    ) = viewModelScope.launch {
        isLoading.value = true
        val request = roverRepository.getOpportunityPhotos(SOL,camera, API_KEY,page)
        when(request){
            is NetworkResult.Success ->{
                roverResponse.value = request.data!!
                isLoading.value = false
            }
            is NetworkResult.Error ->{
                isLoading.value = false
                onError.value = request.message
            }
        }
    }
}