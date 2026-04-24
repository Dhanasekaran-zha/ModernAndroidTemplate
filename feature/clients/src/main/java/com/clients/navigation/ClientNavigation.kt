package com.clients.navigation


import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.clients.ui.ClientScreen
import com.ui.navigation.Screen

fun NavGraphBuilder.clientGraph() {
    composable(route = Screen.Clients.route) {
        ClientScreen(name = "Client")
    }
}