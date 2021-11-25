package com.aldanmaz.cryptotrackapp.viewmodel

import androidx.lifecycle.ViewModel
import com.aldanmaz.cryptotrackapp.model.Crypto
import com.aldanmaz.cryptotrackapp.repository.CryptoRepository
import com.aldanmaz.cryptotrackapp.util.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class CryptoDetailViewModel @Inject constructor(
    private val repository: CryptoRepository
) : ViewModel(){

    suspend fun getCrypto(id : String) : Resource<Crypto> {
        return repository.getCrypto(id)
    }
}