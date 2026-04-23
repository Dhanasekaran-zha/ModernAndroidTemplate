package com.domain.usecase

import com.domain.repository.AuthRepository
import jakarta.inject.Inject

class CheckAuthUseCase @Inject constructor(
    private val repository: AuthRepository
) {
    suspend operator fun invoke(): Boolean = repository.isAuthenticated()
}