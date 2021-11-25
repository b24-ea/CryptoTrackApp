package com.aldanmaz.cryptotrackapp

import android.app.Application
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class CryptoTrackApp : Application(){
    override fun onCreate() {
        super.onCreate()
    }
}