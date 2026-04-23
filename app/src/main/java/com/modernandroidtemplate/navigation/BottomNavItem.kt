package com.modernandroidtemplate.navigation

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.Contacts
import androidx.compose.material.icons.filled.Person
import androidx.compose.ui.graphics.vector.ImageVector
import com.ui.navigation.Screen

sealed class BottomNavItem(
    val route: String,
    val label: String,
    val icon: ImageVector
) {
    object Employees : BottomNavItem(Screen.EmployeeDummy.route, "Employees", Icons.Default.Person)
    object Clients : BottomNavItem(Screen.Clients.route, "Clients", Icons.Default.Contacts)
    object Profile : BottomNavItem(Screen.User.route, "User", Icons.Default.AccountCircle)
}