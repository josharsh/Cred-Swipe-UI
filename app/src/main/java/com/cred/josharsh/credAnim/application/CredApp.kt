package com.cred.josharsh.credAnim.application


import android.app.Application
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class CredApp : Application() {

    override fun onCreate() {
        super.onCreate()
        instance = this
    }

    companion object {
        lateinit var instance: CredApp
    }
}