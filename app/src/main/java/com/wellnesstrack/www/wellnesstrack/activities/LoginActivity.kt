package com.wellnesstrack.www.wellnesstrack.activities

import android.os.Bundle
import android.app.Activity
import android.content.Intent
import android.os.Handler
import android.view.View.GONE
import android.view.View.VISIBLE
import com.wellnesstrack.www.wellnesstrack.WellnessApplication
import com.wellnesstrack.www.wellnesstrack.R
import com.wellnesstrack.www.wellnesstrack.util.WellnessService
import io.github.tonnyl.spark.Spark
import kotlinx.android.synthetic.main.activity_login.*
import javax.inject.Inject

class LoginActivity : Activity() {

    @Inject
    lateinit var wellnessService: WellnessService

    private lateinit var mSpark: Spark

    private var loading: Boolean = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        WellnessApplication.injectionComponent.inject(this)

        mSpark = Spark.Builder()
                .setView(loginLayout) // View or view group
                .setDuration(5000)
                .setAnimList(Spark.ANIM_GREEN_PURPLE)
                .build()

        loginButton.setOnClickListener {
            setLoading(true)
            // TODO: replace with auth call.
            Handler().postDelayed(this::startMainActivity, 2000)
        }

    }

    private fun setLoading(b: Boolean) {
        loading = b
        if (loading) {
            loadingSpinner.visibility = VISIBLE
            loginButton.visibility = GONE
        } else {
            loadingSpinner.visibility = GONE
            loginButton.visibility = VISIBLE
        }
    }

    fun startMainActivity() {
        val token = wellnessService.getRandomTestToken()
        wellnessService.setToken(token)
        intent = Intent(this, MainActivity::class.java)
        startActivity(intent)

    }

    override fun onResume() {
        super.onResume()
        mSpark.startAnimation()
    }

    override fun onPause() {
        super.onPause()
        mSpark.stopAnimation()
    }


}
