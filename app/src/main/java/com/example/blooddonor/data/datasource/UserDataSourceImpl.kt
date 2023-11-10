package com.example.blooddonor.data.datasource

import com.example.blooddonor.data.api.ApiService
import com.example.blooddonor.data.entity.User
import retrofit2.Response
import javax.inject.Inject

class UserDataSourceImpl @Inject constructor(
    private val apiService: ApiService
) : UserDataSource {

    override suspend fun getUsers(): Response<List<User>> {
        return apiService.getUsers()
    }

}