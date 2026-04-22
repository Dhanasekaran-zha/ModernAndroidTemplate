package com.domain.usecase

import com.domain.model.Employee
import com.domain.repository.EmployeeRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetEmployeesUseCase @Inject constructor(
    private val repository: EmployeeRepository
) {
    operator fun invoke(): Flow<List<Employee>> {
        return repository.getEmployees()
    }
}