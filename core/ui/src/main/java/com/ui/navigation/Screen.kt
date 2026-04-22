package com.ui.navigation

sealed class Screen(val route: String) {
    data object AuthGraph : Screen("auth_graph")
    data object Login : Screen("login")

    data object MainGraph : Screen("main_graph")
    data object EmployeeDummy : Screen("employee_dummy")
}