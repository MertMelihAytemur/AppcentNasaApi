package com.example.appcentnasaapi.ui.home.rovers.spirit


import androidx.lifecycle.ViewModel
import com.example.appcentnasaapi.core.base.BaseViewModel
import com.example.appcentnasaapi.domain.usecase.spirit.IGetSpiritPhotosUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

/**
 *Created by Mert Melih Aytemur on 30.04.2022.
 */
@HiltViewModel
class SpiritViewModel @Inject constructor(
    private val getSpiritPhotosUseCase: IGetSpiritPhotosUseCase
) : BaseViewModel() {


}