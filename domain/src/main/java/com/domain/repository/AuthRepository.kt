package com.domain.repository

import com.domain.model.AuthResult
import com.utils.network.Resource
import kotlinx.coroutines.flow.Flow

interface AuthRepository {
    suspend fun login(email: String, pass: String): Flow<Resource<AuthResult>>
    suspend fun isAuthenticated(): Boolean
}