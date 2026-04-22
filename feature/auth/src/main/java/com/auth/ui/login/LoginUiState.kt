package com.auth.ui.login

sealed class LoginUiState {
    data object Idle : LoginUiState()
    data object Loading : LoginUiState()
    data class Success(val message: String) : LoginUiState()
    data class Error(val error: String) : LoginUiState()
}