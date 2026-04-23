package com.employees.navigation


import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.employees.ui.DummyEmployeeScreen
import com.ui.navigation.Screen

fun NavGraphBuilder.employeeGraph() {
    composable(route = Screen.EmployeeDummy.route) {
        // For now, this can just be the dummy screen or the actual EmployeeScreen
        DummyEmployeeScreen(name = "Employee")
    }
}

fun NavGraphBuilder.clientGraph() {
    composable(route = Screen.Clients.route) {
        // For now, this can just be the dummy screen or the actual EmployeeScreen
        DummyEmployeeScreen(name = "Client")
    }
}

fun NavGraphBuilder.userGraph() {
    composable(route = Screen.User.route) {
        // For now, this can just be the dummy screen or the actual EmployeeScreen
        DummyEmployeeScreen(name = "User")
    }
}

