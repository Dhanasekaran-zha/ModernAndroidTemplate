package com.data.remote

import com.data.remote.dto.requests.LoginRequest
import com.data.remote.dto.responses.AuthResponse
import retrofit2.http.Body
import retrofit2.http.POST

interface ApiService {
    @POST("auth/login")
    suspend fun login(@Body request: LoginRequest): AuthResponse
//
//    @POST("auth/signup")
//    suspend fun signup(@Body request: SignupRequest): AuthResponseDto
//
//    @GET("employees")
//    suspend fun getEmployees(): List<EmployeeDto>
//
//    @GET("clients")
//    suspend fun getClients(): List<ClientDto>
//
//    @POST("clients")
//    suspend fun addClient(@Body client: ClientDto): ClientDto
}