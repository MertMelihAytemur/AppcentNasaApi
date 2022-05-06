package com.example.appcentnasaapi.util.extensions

import android.widget.TextView
import androidx.databinding.BindingAdapter

/**
 *Created by Mert Melih Aytemur on 5.05.2022.
 */
@BindingAdapter("setPhotoTakenDate")
fun setPhotoTakenDate(textView: TextView, date : String?){
    date?.let {
        textView.text = "Photo Taken Date: $date"
    }
}

@BindingAdapter("setRoverName")
fun setRoverName(textView: TextView, roverName : String?){
    roverName?.let {
        textView.text = "Rover Name: $roverName"
    }
}

@BindingAdapter("setCameraName")
fun setCameraName(textView: TextView, cameraName : String?){
    cameraName?.let {
        textView.text = "Camera Name: $cameraName"
    }
}

@BindingAdapter("setActivityState")
fun setActivityState(textView: TextView, state : String?){
    state?.let {
        textView.text = "Activity State: $state"
    }
}
@BindingAdapter("setLaunchingDate")
fun setLaunchingDate(textView: TextView, date : String?){
    date?.let {
        textView.text = "Launching Date: $date"
    }
}

@BindingAdapter("setLandingDate")
fun setLandingDate(textView: TextView, date : String?){
    date?.let {
        textView.text = "Landing Date: $date"
    }
}