package com.example.widgetsapplication

import android.app.Application
import androidx.appcompat.app.AppCompatDelegate
import com.example.widgetsapplication.utils.isNight
import dagger.hilt.android.HiltAndroidApp
import kotlinx.coroutines.ExperimentalCoroutinesApi


@ExperimentalCoroutinesApi
@HiltAndroidApp
class MyApplication :Application(){

    override fun onCreate() {
        super.onCreate()

        // change the app theme on the basis of time
        val mode = if(isNight()){
            AppCompatDelegate.MODE_NIGHT_YES
        }else{
            AppCompatDelegate.MODE_NIGHT_NO
        }
        AppCompatDelegate.setDefaultNightMode(mode)

    }

}