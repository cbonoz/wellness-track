package com.wellnesstrack.www.wellnesstrack.injection

import com.wellnesstrack.www.wellnesstrack.services.firebase.WellnessFirebaseIDInstanceService
import com.wellnesstrack.www.wellnesstrack.activities.*

import javax.inject.Singleton

import dagger.Component

@Singleton
@Component(modules = arrayOf(WellnessModule::class))
interface InjectionComponent {

    // Activities
    fun inject(activity: LoginActivity)

    fun inject(activity: MainActivity)
    fun inject(activity: SplashActivity)

    // Fragments
//    fun inject(favoritesFragment: FavoritesFragment)
//    fun inject(wellnessFragment: WellnessFragment)
//    fun inject(recipeFragment: RecipeFragment)
    // Other
    fun inject(wellnessFirebaseIDInstanceService: WellnessFirebaseIDInstanceService)
}
