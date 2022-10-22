package com.example.appcentnasaapi.core.network

import java.lang.Exception

/**
 *Created by Mert Melih Aytemur on 30.04.2022.
 */
sealed class Response<out T>{

    object Loading : Response<Nothing>()

    data class Success<out T>(val data: T?) : Response<T>()

    data class Error<out T>(val exception: Exception) : Response<T>()

    object Empty : Response<Nothing>()

    fun onSuccess(successHandler: (T?) -> Unit): Response<T> = this.also {
        if (this is Success) {
            successHandler(data)
        }
    }

    fun onError(errorHandler: (Response.Error<out T>) -> Unit): Response<T> = this.also {
        if (this is Error) {
            errorHandler(this)
        }
    }

    fun onLoading(loadingHandler: () -> Unit): Response<T> = this.also {
        if (this is Loading) {
            loadingHandler()
        }
    }
}