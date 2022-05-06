package com.example.appcentnasaapi.util.extensions

import com.example.appcentnasaapi.model.roverResponse.Photo

/**
 *Created by Mert Melih Aytemur on 30.04.2022.
 */
interface OnItemClickListener {
    fun onClick(photoDetail : Photo)
}