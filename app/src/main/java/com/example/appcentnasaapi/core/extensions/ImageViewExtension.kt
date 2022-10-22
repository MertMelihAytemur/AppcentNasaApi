package com.example.appcentnasaapi.core.extensions

import android.content.Context
import android.widget.ImageView
import androidx.swiperefreshlayout.widget.CircularProgressDrawable
import coil.load

/**
 *Created by Mert Melih Aytemur on 30.04.2022.
 */

fun ImageView.loadImageView(url : String?){
    val placeHolder = createPlaceHolder(this.context)
    this.load(url){
        crossfade(true)
        crossfade(500)
        placeholder(placeHolder)
    }
}

private fun createPlaceHolder(context : Context) : CircularProgressDrawable{
    return CircularProgressDrawable(context).apply {
        strokeWidth = 12f
        centerRadius = 40f
        start()
    }
}