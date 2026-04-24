package com.profile.navigation


import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.profile.ui.ProfileScreen
import com.ui.navigation.Screen


fun NavGraphBuilder.profileGraph() {
    composable(route = Screen.User.route) {
        // For now, this can just be the dummy screen or the actual EmployeeScreen
        ProfileScreen(name = "User")
    }
}

