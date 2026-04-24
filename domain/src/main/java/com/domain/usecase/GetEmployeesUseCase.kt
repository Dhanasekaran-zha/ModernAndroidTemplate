package com.domain.usecase

import com.domain.model.Employee
import com.domain.repository.EmployeeRepository
import com.utils.network.Resource
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetEmployeesUseCase @Inject constructor(
    private val repository: EmployeeRepository
) {
    operator fun invoke(): Flow<Resource<List<Employee>>> {
        return repository.getEmployees()
    }
}