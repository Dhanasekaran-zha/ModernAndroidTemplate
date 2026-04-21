@file:OptIn(InternalSerializationApi::class)

package com.data.remote.dto.responses

import kotlinx.serialization.InternalSerializationApi
import kotlinx.serialization.Serializable

@Serializable
data class EmployeeResponse(
    val id: Int,
    val firstName: String,
    val lastName: String,
    val email: String,
    val role: String
)