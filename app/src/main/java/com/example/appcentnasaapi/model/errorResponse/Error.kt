package com.example.appcentnasaapi.model.errorResponse


import com.google.gson.annotations.SerializedName

data class Error(
    @SerializedName("code")
    val code: String?,
    @SerializedName("message")
    val message: String?
)