package com.aldanmaz.cryptotrackapp.service

import com.aldanmaz.cryptotrackapp.model.Crypto
import com.aldanmaz.cryptotrackapp.model.CryptoList
import retrofit2.http.GET
import retrofit2.http.Query


interface CryptoAPI {

    //prices?key=76e11812a2cbe05b9c5054ec166de582a1326308
    @GET("prices")
    suspend fun getCryptoList(
        @Query("key") key : String,
    ) : CryptoList


    //currencies?key=76e11812a2cbe05b9c5054ec166de582a1326308&ids=BTC&attributes=id,name,logo_url
    @GET("currencies")
    suspend fun  getCrypto(
        @Query("key") key : String,
        @Query("ids") id : String,
        @Query("attributes") attributes : String
    ) : Crypto
}