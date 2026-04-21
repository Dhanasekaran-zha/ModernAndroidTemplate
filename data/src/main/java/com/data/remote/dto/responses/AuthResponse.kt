@file:OptIn(InternalSerializationApi::class)

package com.data.remote.dto.responses

import kotlinx.serialization.InternalSerializationApi
import kotlinx.serialization.Serializable

@Serializable
data class AuthResponse(
    val token: String,
    val userId: Int,
    val email: String
)