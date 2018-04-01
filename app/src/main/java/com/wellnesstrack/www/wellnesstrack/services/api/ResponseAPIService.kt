package com.wellnesstrack.www.wellnesstrack.services.api

import api.ResponseRep
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Path

/**

 * Created by kyleareanraines on 3/14/17.
 */

interface ResponseAPIService {

    @GET("/responses/user/{user}")
    @Throws(Exception::class)
    fun findByUser(@Path("user") user: String): Call<ResponseRep>

    @GET("/responses/question/{question}")
    @Throws(Exception::class)
    fun findByQuestion(@Path("question") question: String): Call<ResponseRep>

    @POST("/responses/create")
    @Throws(Exception::class)
    fun create(@Body response: ResponseRep): Call<ResponseRep>
}
