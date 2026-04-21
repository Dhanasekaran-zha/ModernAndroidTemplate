@file:OptIn(InternalSerializationApi::class)

package com.data.remote.dto.requests

import kotlinx.serialization.InternalSerializationApi
import kotlinx.serialization.Serializable

@Serializable
data class LoginRequest(
    val email: String,
    val password: String,
)

@Serializable
data class SignupRequest(
    val name: String,
    val email: String,
    val password: String
)