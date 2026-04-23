package com.example.modernandroidtemplate.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.domain.usecase.CheckAuthUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SplashViewModel @Inject constructor(
    private val checkAuthUseCase: CheckAuthUseCase
) : ViewModel() {

    // Controls whether the system splash screen stays visible
    private val _isLoading = MutableStateFlow(true)
    val isLoading = _isLoading.asStateFlow()

    // Holds the final decision on where to navigate
    private val _isAuthenticated = MutableStateFlow(false)
    val isAuthenticated = _isAuthenticated.asStateFlow()

    init {
        checkAuthentication()
    }

    private fun checkAuthentication() {
        viewModelScope.launch {
            try {
                // 1. Check if the token exists in DataStore
                val isAuth = checkAuthUseCase()
                _isAuthenticated.value = isAuth

                // 2. Optional: Add a tiny delay (e.g., 500ms) to prevent
                // the splash from "flickering" too fast on high-end devices.
                delay(500)
            } catch (e: Exception) {
                _isAuthenticated.value = false
            } finally {
                // 3. Tell MainActivity we are done loading
                _isLoading.value = false
            }
        }
    }
}