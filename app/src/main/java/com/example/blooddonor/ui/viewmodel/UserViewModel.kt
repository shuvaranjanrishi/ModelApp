package com.example.blooddonor.ui.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.blooddonor.data.entity.User
import com.example.blooddonor.ui.repository.UserRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import com.example.utilities.Result
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.collectLatest
import javax.inject.Inject

@HiltViewModel
class UserViewModel @Inject constructor(
    private val userRepository: UserRepository
) : ViewModel() {

    private val _users: MutableStateFlow<Result<List<User>>> = MutableStateFlow(Result.Loading())
    val users: StateFlow<Result<List<User>>> = _users

    init {
        getUsers()
    }

    private fun getUsers() {
        viewModelScope.launch(Dispatchers.IO) {
            userRepository.getUsers().collectLatest { userResponse ->
                delay(4000)
                _users.value = userResponse
            }
        }
    }

    companion object {
        const val TAG = "BloodDonorViewModel"
    }
}