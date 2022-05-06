package com.example.appcentnasaapi.util.base


import com.example.appcentnasaapi.util.network.NetworkResult
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

import retrofit2.HttpException

/**
 *Created by Mert Melih Aytemur on 30.04.2022.
 */

abstract class BaseRepository {
    suspend fun <T> safeApiRequest(
        apiRequest: suspend () -> T
    ): NetworkResult<T> {
        return withContext(Dispatchers.IO) {
            try {
                NetworkResult.Success(apiRequest.invoke())
            } catch (throwable: Throwable) {
                when (throwable) {
                    is HttpException -> {
                        NetworkResult.Error(false, throwable.response()?.errorBody()?.toString())
                    }
                    else -> NetworkResult.Error(true, throwable.localizedMessage)
                }
            }
        }
    }


    /*private fun errorBodyParse(error: String): String? {
        error?.let {
            return try {
                val errorMessaeg = Gson().fromJson(error, ErrorResponse::class.java)
                val errorMessage = errorResponse.status?.errorMessage
                errorMessage ?: "An Error occurred."
            } catch (e: Exception) {
                return "An Error occurred."
            }
        }
        return "An Error occurred."
    }*/

}