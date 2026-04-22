@file:OptIn(InternalSerializationApi::class)

package com.data.remote.dto.responses

import kotlinx.serialization.InternalSerializationApi
import kotlinx.serialization.Serializable
import kotlinx.serialization.SerialName

@Serializable
data class LoginResponse(

    @SerialName("code")
    val code: Int? = null,

    @SerialName("message")
    val message: String? = null,

    @SerialName("loginData")
    val loginData: LoginData? = null,

    @SerialName("status")
    val status: String? = null
)

@Serializable
data class LoginData(

    @SerialName("accessToken")
    val accessToken: String? = null,

    @SerialName("user")
    val user: User? = null
)

@Serializable
data class User(

    @SerialName("role")
    val role: String? = null,

    @SerialName("id")
    val id: String? = null,

    @SerialName("email")
    val email: String? = null,

    @SerialName("username")
    val username: String? = null
)
