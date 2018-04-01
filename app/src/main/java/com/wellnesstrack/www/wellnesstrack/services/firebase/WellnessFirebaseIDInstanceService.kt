package com.wellnesstrack.www.wellnesstrack.services.firebase

import android.util.Log

import com.google.firebase.iid.FirebaseInstanceId
import com.google.firebase.iid.FirebaseInstanceIdService
import com.wellnesstrack.www.WellnessApplication
import com.wellnesstrack.www.wellnesstrack.managers.UserSessionManager
import com.wellnesstrack.www.services.api.TokenAPIService
import com.wellnesstrack.www.wellnesstrack.WellnessApplication
import com.wellnesstrack.www.wellnesstrack.services.api.TokenAPIService

import javax.inject.Inject

/**

 * Created by kyleareanraines on 4/7/17.
 */

class WellnessFirebaseIDInstanceService : FirebaseInstanceIdService() {

    @Inject
    lateinit var tokenAPIService: TokenAPIService
    @Inject
    lateinit var userSessionManager: UserSessionManager

    init {
        WellnessApplication.injectionComponent.inject(this)
    }

    override fun onTokenRefresh() {
        val token = FirebaseInstanceId.getInstance().token
        Log.d(TAG, "TOKEN: " + token!!)
        try {
            tokenAPIService!!.addToken(userSessionManager.user!!.uid, token)
        } catch (e: Exception) {
            Log.e(TAG, e.toString())
        }

    }

    companion object {

        private val TAG = "MyFirebaseIIDService"
    }
}
