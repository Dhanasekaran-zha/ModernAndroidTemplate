package com.employees.navigation


import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.employees.ui.employeeList.EmployeeScreen
import com.ui.navigation.Screen

fun NavGraphBuilder.employeeGraph() {
    composable(route = Screen.EmployeeDummy.route) {
        EmployeeScreen()
    }
}

