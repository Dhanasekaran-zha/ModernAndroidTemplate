package com.employees.viewModels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.domain.usecase.GetEmployeesUseCase
import com.employees.ui.employeeList.EmployeeScreenUiState
import com.utils.network.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class EmployeeViewModel @Inject constructor(
    private val employeesUseCase: GetEmployeesUseCase
) : ViewModel() {

    private val _uiState = MutableStateFlow<EmployeeScreenUiState>(EmployeeScreenUiState.Idle)
    val uiState: StateFlow<EmployeeScreenUiState> = _uiState.asStateFlow()

    init {
        getEmployees()
    }
    fun getEmployees() {
        viewModelScope.launch {
            employeesUseCase().collect { resource ->
                _uiState.value = when (resource) {
                    is Resource.Loading -> {
                        EmployeeScreenUiState.Loading
                    }

                    is Resource.Success -> {
                        EmployeeScreenUiState.Success(resource.data)
                    }

                    is Resource.Error -> {
                        EmployeeScreenUiState.Error(resource.message)
                    }
                }
            }
        }
    }

}