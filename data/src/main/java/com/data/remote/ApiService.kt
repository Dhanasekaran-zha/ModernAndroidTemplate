package com.data.remote

import com.data.remote.dto.requests.LoginRequest
import com.data.remote.dto.responses.AuthResponse
import com.data.remote.dto.responses.EmployeeResponse
import com.data.remote.dto.responses.LoginResponse
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST

interface ApiService {
    @POST("auth/login")
    suspend fun login(@Body request: LoginRequest): LoginResponse

    @GET("candidate/all?page=1&limit=10")
    suspend fun getEmployees(): EmployeeResponse
//
//    @POST("auth/signup")
//    suspend fun signup(@Body request: SignupRequest): AuthResponseDto
//
//
//    @GET("clients")
//    suspend fun getClients(): List<ClientDto>
//
//    @POST("clients")
//    suspend fun addClient(@Body client: ClientDto): ClientDto
}