package com.example.appcentnasaapi.domain.mapper

/**
 *Created by Mert Melih Aytemur on 22.10.2022.
 */
interface Mapper<in Input, out Output> {
    fun map(input: Input) : Output
}