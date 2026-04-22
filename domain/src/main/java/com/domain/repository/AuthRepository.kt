package com.domain.repository

import com.domain.model.AuthResult

interface AuthRepository {
    suspend fun login(email: String, pass: String): Result<AuthResult>
}