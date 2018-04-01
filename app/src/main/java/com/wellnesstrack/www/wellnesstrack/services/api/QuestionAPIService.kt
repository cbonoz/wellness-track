package com.wellnesstrack.www.wellnesstrack.services.api

import api.QuestionRep
import api.ResponseRep
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.DELETE
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.PUT
import retrofit2.http.Path
import retrofit2.http.Query

/**
 * Created by kyleareanraines on 3/14/17.
 */

interface QuestionAPIService {

    @GET("/questions/user/{user}")
    @Throws(Exception::class)
    fun getAllQuestionsByUser(@Path("user") user: String): Call<List<QuestionRep>>

    @POST("/questions/create/{token}")
    @Throws(Exception::class)
    fun createQuestion(@Body questionRep: QuestionRep, @Path("token") token: String): Call<QuestionRep>

    @DELETE("/questions/{question}")
    @Throws(Exception::class)
    fun deleteQuestion(@Path("question") questionId: String): Call<QuestionRep>

    @PUT("/questions/update/{token}")
    @Throws(Exception::class)
    fun updateQuestion(@Body questionRep: QuestionRep, @Path("token") token: String): Call<QuestionRep>

    @GET("/questions/unanswered/{user}")
    @Throws(Exception::class)
    fun getUnansweredQuestionsByUser(@Path("user") user: String): Call<List<QuestionRep>>

    @GET("/responses/user/{user}")
    @Throws(Exception::class)
    fun getUserHistory(@Path("user") user: String, @Query("lower") lower: String,
                       @Query("upper") upper: String): Call<List<ResponseRep>>

    @GET("/question/{question}")
    @Throws(Exception::class)
    fun getQuestionHistory(@Path("question") questionId: String, @Query("lower") lower: String?,
                           @Query("upper") upper: String?): Call<List<ResponseRep>>
}
