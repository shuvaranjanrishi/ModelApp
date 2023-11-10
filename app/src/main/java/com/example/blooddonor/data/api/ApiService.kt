package com.example.blooddonor.data.api

import com.example.blooddonor.data.entity.User
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Headers

interface ApiService {

    @Headers("Accept: application/json")
    @GET("users")
    suspend fun getUsers(): Response<List<User>>
}