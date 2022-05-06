package com.example.appcentnasaapi.util.extensions

import androidx.appcompat.widget.AppCompatImageView
import androidx.databinding.BindingAdapter
import com.squareup.picasso.Picasso

@BindingAdapter("setImageURL")
fun setImageURL(imageView: AppCompatImageView, imageURL: String?) {
   imageURL?.let {
        Picasso.get().load(it).into(imageView)
   }
}
