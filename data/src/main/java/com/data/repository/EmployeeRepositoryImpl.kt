package com.data.repository

import com.data.mapper.toEmployee
import com.data.remote.ApiService
import com.domain.model.Employee
import com.domain.repository.EmployeeRepository
import com.network.utils.safeApiCall
import com.utils.network.Resource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class EmployeeRepositoryImpl @Inject constructor(
    private val apiService: ApiService
) : EmployeeRepository {
    override fun getEmployees(): Flow<Resource<List<Employee>>> = flow {
        emit(Resource.Loading)
        val result = safeApiCall {
            apiService.getEmployees()
        }

        when (result) {
            is Resource.Success -> {
                val employees = result.data.employeeData.candidates.map { candidate ->
                    candidate.toEmployee()
                }

                emit(Resource.Success(employees))
            }

            is Resource.Error -> emit(Resource.Error(result.message))
            else -> Unit
        }
    }

    override suspend fun refreshEmployees() {
        TODO("Not yet implemented")
    }

}