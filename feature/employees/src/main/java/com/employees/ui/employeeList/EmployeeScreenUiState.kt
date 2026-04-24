package com.employees.ui.employeeList

import com.domain.model.Employee

sealed class EmployeeScreenUiState {
    data object Idle : EmployeeScreenUiState()
    data object Loading : EmployeeScreenUiState()
    data class Success(val employees: List<Employee>) : EmployeeScreenUiState()
    data class Error(val error: String) : EmployeeScreenUiState()
}