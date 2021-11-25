package com.aldanmaz.cryptotrackapp.di

import com.aldanmaz.cryptotrackapp.repository.CryptoRepository
import com.aldanmaz.cryptotrackapp.service.CryptoAPI
import com.aldanmaz.cryptotrackapp.util.Constants.BASE_URL
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Singleton
    @Provides
    fun provideCryptoRepository(
        api : CryptoAPI
    ) = CryptoRepository(api)

    @Singleton
    @Provides
    fun provideCryptoApi() : CryptoAPI {
        return Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl(BASE_URL)
            .build()
            .create(CryptoAPI::class.java)
    }

}