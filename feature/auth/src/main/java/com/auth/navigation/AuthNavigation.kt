package com.auth.navigation

import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.auth.ui.login.LoginScreen
import com.ui.navigation.Screen


fun NavGraphBuilder.authGraph(
    onLoginSuccess: () -> Unit
) {
    composable(route = Screen.Login.route) {
        LoginScreen(
            onLoginSuccess = onLoginSuccess
        )
    }
}