package com.example.appcentnasaapi.util.bindingadapter


import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.example.appcentnasaapi.util.extensions.loadImageView

/**
 *Created by Mert Melih Aytemur on 30.04.2022.
 */
class RoverPhotoBinding{
    companion object{
        @BindingAdapter("load_image")
        @JvmStatic
        fun loadImage(imageView : ImageView, imageUrl : String){
            imageView.loadImageView(imageUrl)
        }
    }
}