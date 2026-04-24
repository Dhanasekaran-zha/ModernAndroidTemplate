@file:OptIn(InternalSerializationApi::class)

package com.data.remote.dto.responses

import kotlinx.serialization.InternalSerializationApi
import kotlinx.serialization.Serializable
import kotlinx.serialization.SerialName

@Serializable
data class EmployeeResponse(

	@SerialName("code")
	val code: Int,

	@SerialName("message")
	val message: String,

	@SerialName("data")
	val employeeData: EmployeeData,

	@SerialName("status")
	val status: String
)

@Serializable
data class Client(

	@SerialName("agencyPlace")
	val agencyPlace: String,

	@SerialName("country")
	val country: String,

	@SerialName("createdAt")
	val createdAt: String,

	@SerialName("phoneNumber")
	val phoneNumber: String,

	@SerialName("city")
	val city: String,

	@SerialName("companyName")
	val companyName: String,

	@SerialName("contactPerson")
	val contactPerson: String,

	@SerialName("industry")
	val industry: String,

	@SerialName("id")
	val id: String,

	@SerialName("email")
	val email: String,

	@SerialName("agencyName")
	val agencyName: String,

	@SerialName("updatedAt")
	val updatedAt: String
)

@Serializable
data class Interview(

	@SerialName("createdAt")
	val createdAt: String,

	@SerialName("serviceCharge")
	val serviceCharge: String,

	@SerialName("contractType")
	val contractType: String,

	@SerialName("interviewDate")
	val interviewDate: String,

	@SerialName("id")
	val id: String,

	@SerialName("candidateId")
	val candidateId: String,

	@SerialName("paymentStatus")
	val paymentStatus: String,

	@SerialName("updatedAt")
	val updatedAt: String
)

@Serializable
data class EmployeeData(

	@SerialName("candidates")
	val candidates: List<Candidates>,

	@SerialName("total")
	val total: Int,

	@SerialName("limit")
	val limit: Int,

	@SerialName("totalPages")
	val totalPages: Int,

	@SerialName("page")
	val page: Int
)

@Serializable
data class Candidates(

	@SerialName("passportNumber")
	val passportNumber: String,

	@SerialName("clientId")
	val clientId: String,

	@SerialName("jobTitle")
	val jobTitle: String,

	@SerialName("dateOfBirth")
	val dateOfBirth: String,

	@SerialName("passportType")
	val passportType: String,

	@SerialName("photoCopy")
	val photoCopy: String,

	@SerialName("Interview")
	val interview: Interview ?= null,

	@SerialName("createdAt")
	val createdAt: String,

	@SerialName("phoneNumber")
	val phoneNumber: String,

	@SerialName("name")
	val name: String,

	@SerialName("passportCopy")
	val passportCopy: String,

	@SerialName("client")
	val client: Client,

	@SerialName("id")
	val id: String,

	@SerialName("age")
	val age: Int,

	@SerialName("status")
	val status: String,

	@SerialName("updatedAt")
	val updatedAt: String
)
