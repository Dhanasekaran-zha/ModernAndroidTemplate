package com.domain.usecase

import com.domain.model.AuthResult
import com.domain.repository.AuthRepository
import javax.inject.Inject

class LoginUseCase @Inject constructor(
    private val repository: AuthRepository
) {
    suspend operator fun invoke(email: String, pass: String): Result<AuthResult> {
        if (email.isBlank() || pass.isBlank()) {
            return Result.failure(Exception("Credentials cannot be empty"))
        }
        return repository.login(email, pass)
    }
}