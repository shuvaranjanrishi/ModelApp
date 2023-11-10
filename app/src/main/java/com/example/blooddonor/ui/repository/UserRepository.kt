package com.example.blooddonor.ui.repository

import com.example.blooddonor.data.datasource.UserDataSource
import com.example.blooddonor.data.entity.User
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject
import com.example.utilities.Result
import kotlinx.coroutines.flow.catch

class UserRepository @Inject constructor(
    private val userDataSource: UserDataSource
) {
//    suspend fun getUsers(): Response<UserResponse> {
//        return userDataSource.getUsers()
//    }

    suspend fun getUsers(): Flow<Result<List<User>>> {
        return flow {
            emit(Result.Loading())

            val response = userDataSource.getUsers()
            if (response.isSuccessful && response.body() != null) {
                emit(Result.Success(response.body()!!))
            } else {
                emit(Result.Error(response.errorBody().toString()))
            }
        }.catch { e ->
            emit(Result.Error(e.localizedMessage ?: "Something went wrong"))
        }
    }
}