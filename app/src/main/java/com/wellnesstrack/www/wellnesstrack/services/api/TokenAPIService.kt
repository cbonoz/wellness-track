package com.wellnesstrack.www.wellnesstrack.services.api

import retrofit2.Call
import retrofit2.http.PUT
import retrofit2.http.Path


/**

 * Created by kyleareanraines on 3/14/17.
 */

interface TokenAPIService {

    @PUT("/token/{userId}/{token}")
    @Throws(Exception::class)
    fun addToken(@Path("userId") userId: String, @Path("token") token: String): Call<String>

}
