package com.wellnesstrack.www.wellnesstrack.managers

import android.util.Log

import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import com.google.firebase.iid.FirebaseInstanceId
import com.wellnesstrack.www.wellnesstrack.services.api.TokenAPIService

/**
 * Created on 4/1/17.
 */
class UserSessionManager(private val tokenAPIService: TokenAPIService) {

    var user: FirebaseUser? = null

    val auth: FirebaseAuth

    private val mAuthListener = FirebaseAuth.AuthStateListener { firebaseAuth ->
        val currentUser = firebaseAuth.currentUser
        if (currentUser != null) {
            // User is signed in
            Log.d(TAG, "onAuthStateChanged:signed_in:" + currentUser.uid)
            this.user = currentUser
            removeAuthListener()
            try {
                tokenAPIService.addToken(currentUser.uid, FirebaseInstanceId.getInstance().token!!)
            } catch (e: Exception) {
                Log.e(TAG, e.toString())
            }

        } else {
            // User is signed out
            this.user = null
            Log.d(TAG, "onAuthStateChanged:signed_out")
        }
    }

    init {
        auth = FirebaseAuth.getInstance()
    }

    fun logout() {
        auth.signOut()
    }

    fun addAuthListener() {
        auth.addAuthStateListener(mAuthListener)
    }

    fun removeAuthListener() {
        try {
            auth.removeAuthStateListener(mAuthListener)
        } catch (e: Exception) {
            Log.e(TAG, "Could not remove auth listener: " + mAuthListener)
        }
    }

    companion object {
        private val TAG = "UserSessionManager"
    }

}
