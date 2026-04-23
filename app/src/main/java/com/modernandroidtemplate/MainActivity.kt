package com.modernandroidtemplate

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import androidx.navigation.compose.rememberNavController
import com.example.modernandroidtemplate.viewmodel.SplashViewModel
import com.modernandroidtemplate.navigation.RootNavGraph
import com.modernandroidtemplate.ui.theme.ModernAndroidTemplateTheme
import com.ui.navigation.Screen
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    private val viewModel: SplashViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val splashScreen = installSplashScreen()
        enableEdgeToEdge()
        splashScreen.setKeepOnScreenCondition {
            viewModel.isLoading.value
        }
        setContent {
            ModernAndroidTemplateTheme {
                val isAuthenticated by viewModel.isAuthenticated.collectAsState()

                if (!viewModel.isLoading.collectAsState().value) {
                    val navController = rememberNavController()
                    val startRoute = if (isAuthenticated) Screen.EmployeeDummy else Screen.Login

                    RootNavGraph(
                        navController = navController,
                        startDestination = startRoute
                    )
                }
            }
        }
    }
}