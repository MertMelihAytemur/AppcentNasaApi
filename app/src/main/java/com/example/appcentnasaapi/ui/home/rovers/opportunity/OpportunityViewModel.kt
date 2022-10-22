package com.example.appcentnasaapi.ui.home.rovers.opportunity

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.appcentnasaapi.domain.model.roverResponse.RoverResponse
import com.example.appcentnasaapi.data.repository.RoverRepository
import com.example.appcentnasaapi.core.Const.API_KEY
import com.example.appcentnasaapi.core.Const.SOL
import com.example.appcentnasaapi.core.base.BaseViewModel
import com.example.appcentnasaapi.core.network.Response
import com.example.appcentnasaapi.domain.usecase.opportunity.GetOpportunityUseCase
import com.example.appcentnasaapi.domain.usecase.opportunity.IGetOpportunityPhotosUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

/**
 *Created by Mert Melih Aytemur on 30.04.2022.
 */
@HiltViewModel
class OpportunityViewModel @Inject constructor(
    private val getOpportunityUseCase: IGetOpportunityPhotosUseCase
) : BaseViewModel() {

}