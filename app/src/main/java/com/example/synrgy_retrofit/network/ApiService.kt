package com.example.synrgy_retrofit.network

import com.example.synrgy_retrofit.pojo.*
import retrofit2.Call
import retrofit2.http.*

interface ApiService{
    @GET("persons")
    fun getAllPersons(): Call<GetPersonsResponse>

    @POST("person")
    fun addPerson(@Body postPersonBody: PostPersonBody): Call<PostPersonResponse>

    @PUT("person/{id}")
    fun updatePerson(@Path("id") id: String, @Body putPersonBody: PutPersonBody): Call<PutPersonResponse>

    @DELETE("person/{id}")
    fun deletePerson(@Path("id") id: String): Call<DeletePersonResponse>
}