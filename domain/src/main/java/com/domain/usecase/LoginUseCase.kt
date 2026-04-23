package com.domain.usecase

import com.domain.model.AuthResult
import com.domain.repository.AuthRepository
import com.utils.network.Resource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOf
import javax.inject.Inject

class LoginUseCase @Inject constructor(
    private val repository: AuthRepository
) {
    suspend operator fun invoke(
        email: String,
        pass: String
    ): Flow<Resource<AuthResult>> {

        if (email.isBlank() || pass.isBlank()) {
            return flowOf(Resource.Error("Credentials cannot be empty"))
        }

        return repository.login(email, pass)
    }
}