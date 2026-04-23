package com.auth.viewModels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.auth.ui.login.LoginUiState
import com.domain.usecase.LoginUseCase
import com.utils.network.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class LoginViewModel @Inject constructor(
    private val loginUseCase: LoginUseCase
) : ViewModel() {

    private val _uiState = MutableStateFlow<LoginUiState>(LoginUiState.Idle)
    val uiState: StateFlow<LoginUiState> = _uiState.asStateFlow()

    fun login(email: String, pass: String) {
        viewModelScope.launch {
            // 1. Call the UseCase which now returns a Flow
            loginUseCase(email, pass).collect { resource ->

                // 2. Map the emitted Resource states to your UI State
                _uiState.value = when (resource) {
                    is Resource.Loading -> {
                        LoginUiState.Loading
                    }
                    is Resource.Success -> {
                        LoginUiState.Success("Logged in as ${resource.data.userEmail}")
                    }
                    is Resource.Error -> {
                        LoginUiState.Error(resource.message)
                    }
                }
            }
        }
    }
}