package com.modernandroidtemplate.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import com.auth.navigation.authGraph
import com.employees.navigation.employeeGraph
import com.ui.navigation.Screen


@Composable
fun RootNavGraph(navController: NavHostController, startDestination: Screen) {
    NavHost(
        navController = navController,
        startDestination = startDestination.route
    ) {
        authGraph(
            onLoginSuccess = {
                navController.navigate(Screen.EmployeeDummy.route) {
                    popUpTo(Screen.Login.route) { inclusive = true }
                }
            }
        )

        employeeGraph()
    }
}