package com.wellnesstrack.www.wellnesstrack

import android.app.Application
import android.content.Context
import android.util.Log

import com.wellnesstrack.www.wellnesstrack.injection.DaggerInjectionComponent
import com.wellnesstrack.www.wellnesstrack.injection.InjectionComponent
import com.wellnesstrack.www.wellnesstrack.injection.WellnessModule

class WellnessApplication : Application() {
    private var mInjectionComponent: InjectionComponent? = null

    override fun onCreate() {
        super.onCreate()
        Log.d("MyApplication", "onCreate")
        mInjectionComponent = DaggerInjectionComponent.builder()
                .wellnessModule(WellnessModule(this))
                .build()

        app = this
    }

    override fun attachBaseContext(base: Context) {
        super.attachBaseContext(base)
    }

    companion object {

        private var app: WellnessApplication? = null

        val injectionComponent: InjectionComponent
            get() = app!!.mInjectionComponent!!
    }
}
