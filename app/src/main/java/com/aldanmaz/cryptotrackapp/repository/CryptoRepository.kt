package com.aldanmaz.cryptotrackapp.repository

import com.aldanmaz.cryptotrackapp.model.Crypto
import com.aldanmaz.cryptotrackapp.model.CryptoList
import com.aldanmaz.cryptotrackapp.service.CryptoAPI
import com.aldanmaz.cryptotrackapp.util.Constants.API_KEY
import com.aldanmaz.cryptotrackapp.util.Constants.CALL_ATTRIBUTES
import com.aldanmaz.cryptotrackapp.util.Resource
import dagger.hilt.android.scopes.ActivityScoped
import javax.inject.Inject

@ActivityScoped
class CryptoRepository @Inject constructor(
    private val api: CryptoAPI
) {

    suspend fun getCryptoList(): Resource<CryptoList> {
        val response = try {
            api.getCryptoList(API_KEY)
        } catch(e: Exception) {
            return Resource.Error("Error.")
        }
        return Resource.Success(response)
    }

    suspend fun getCrypto(id: String): Resource<Crypto> {
        val response = try {
            api.getCrypto(API_KEY,id,CALL_ATTRIBUTES)
        } catch(e: Exception) {
            return Resource.Error("Error")
        }
        return Resource.Success(response)
    }
}