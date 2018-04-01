package com.wellnesstrack.www.wellnesstrack.injection

import com.google.gson.Gson

import com.wellnesstrack.www.wellnesstrack.WellnessApplication
import com.wellnesstrack.www.wellnesstrack.services.PrefManager
import com.wellnesstrack.www.wellnesstrack.services.WellnessService

import javax.inject.Singleton

import dagger.Module
import dagger.Provides


@Module
class WellnessModule(private val mApplication: WellnessApplication) {

    @Provides
    @Singleton
    internal fun providesApplication(): WellnessApplication {
        return mApplication
    }

    @Provides
    @Singleton
    internal fun providesGson(): Gson {
        return Gson()
    }

    @Provides
    @Singleton
    internal fun providesWellnessService(): WellnessService {
        return WellnessService()
    }

    @Provides
    @Singleton
    internal fun providesPrefManager(app: WellnessApplication, gson: Gson): PrefManager {
        return PrefManager(app, gson)
    }

}
