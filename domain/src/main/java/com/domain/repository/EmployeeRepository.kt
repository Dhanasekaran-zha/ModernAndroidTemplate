package com.domain.repository

import com.domain.model.Employee
import kotlinx.coroutines.flow.Flow

interface EmployeeRepository {
    /**
     * Returns a stream of employees from local cache and triggers a network refresh.
     */
    fun getEmployees(): Flow<List<Employee>>

    suspend fun refreshEmployees()
}