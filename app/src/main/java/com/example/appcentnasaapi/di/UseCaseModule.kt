package com.example.appcentnasaapi.di

import com.example.appcentnasaapi.domain.usecase.curiosity.GetCuriosityPhotosUseCase
import com.example.appcentnasaapi.domain.usecase.curiosity.IGetCuriosityPhotosUseCase
import com.example.appcentnasaapi.domain.usecase.opportunity.GetOpportunityUseCase
import com.example.appcentnasaapi.domain.usecase.opportunity.IGetOpportunityPhotosUseCase
import com.example.appcentnasaapi.domain.usecase.spirit.GetSpiritPhotosUseCase
import com.example.appcentnasaapi.domain.usecase.spirit.IGetSpiritPhotosUseCase
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent

/**
 *Created by Mert Melih Aytemur on 22.10.2022.
 */
@Module
@InstallIn(ViewModelComponent::class)
abstract class UseCaseModule {

    @Binds
    abstract fun bindGetCuriosityUseCase(impl : GetCuriosityPhotosUseCase) : IGetCuriosityPhotosUseCase

    @Binds
    abstract fun bindGetOpportunityUseCase(impl : GetOpportunityUseCase) : IGetOpportunityPhotosUseCase

    @Binds
    abstract fun bindGetSpiritUseCase(impl : GetSpiritPhotosUseCase) : IGetSpiritPhotosUseCase

}