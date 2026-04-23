package com.data.repository

import com.data.remote.ApiService
import com.data.remote.dto.requests.LoginRequest
import com.datastore.managers.TokenManager
import com.domain.model.AuthResult
import com.domain.repository.AuthRepository
import com.network.utils.safeApiCall
import com.utils.network.Resource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class AuthRepositoryImpl @Inject constructor(
    private val apiService: ApiService,
    private val tokenManager: TokenManager
) : AuthRepository {

    override suspend fun login(email: String, pass: String): Flow<Resource<AuthResult>> = flow {
        // Use safeApiCall to handle exceptions automatically
        emit(Resource.Loading)
        val result = safeApiCall {
            apiService.login(LoginRequest(email, pass))
        }

        when (result) {
            is Resource.Success -> {
                tokenManager.saveToken(result.data.loginData.accessToken)
                emit(
                    Resource.Success(
                        AuthResult(
                            result.data.loginData.accessToken,
                            result.data.loginData.user.email
                        )
                    )
                )
            }

            is Resource.Error -> emit(Resource.Error(result.message))
            else -> Unit
        }
    }

    override suspend fun isAuthenticated(): Boolean {
        return tokenManager.authToken.first() != null
    }
}