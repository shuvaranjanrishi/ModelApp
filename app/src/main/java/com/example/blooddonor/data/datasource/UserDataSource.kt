package com.example.blooddonor.data.datasource

import com.example.blooddonor.data.entity.User
import retrofit2.Response

interface UserDataSource {

    suspend fun getUsers(): Response<List<User>>
}