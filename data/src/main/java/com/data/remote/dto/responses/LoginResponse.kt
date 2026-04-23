@file:OptIn(InternalSerializationApi::class)

package com.data.remote.dto.responses

import kotlinx.serialization.InternalSerializationApi
import kotlinx.serialization.Serializable
import kotlinx.serialization.SerialName

@Serializable
data class LoginResponse(

    @SerialName("code")
    val code: Int,

    @SerialName("message")
    val message: String,

    @SerialName("data")
    val loginData: LoginData,

    @SerialName("status")
    val status: String
)

@Serializable
data class LoginData(

    @SerialName("accessToken")
    val accessToken: String,

    @SerialName("user")
    val user: User
)

@Serializable
data class User(

    @SerialName("role")
    val role: String,

    @SerialName("id")
    val id: String,

    @SerialName("email")
    val email: String,

    @SerialName("username")
    val username: String
)
