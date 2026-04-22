package com.data.repository

import com.data.remote.ApiService
import com.data.remote.dto.requests.LoginRequest
import com.datastore.managers.TokenManager
import com.domain.model.AuthResult
import com.domain.repository.AuthRepository
import javax.inject.Inject

class AuthRepositoryImpl @Inject constructor(
    private val apiService: ApiService,
    private val tokenManager: TokenManager
) : AuthRepository {

    override suspend fun login(email: String, pass: String): Result<AuthResult> {
        return try {
            val response = apiService.login(LoginRequest(email, pass))
            // Save token to DataStore
            tokenManager.saveToken(response.token)

            Result.success(AuthResult(response.token, response.email))
        } catch (e: Exception) {
            Result.failure(e)
        }
    }
}