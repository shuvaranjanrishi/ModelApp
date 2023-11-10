package com.example.blooddonor.ui.app

import android.app.Application
import android.util.Log
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class BloodDonorApplication : Application() {

    override fun onCreate() {
        super.onCreate()
        Log.d(TAG, "onCreate")
    }

    companion object {
        const val TAG = "BloodDonorApplication"
    }
}