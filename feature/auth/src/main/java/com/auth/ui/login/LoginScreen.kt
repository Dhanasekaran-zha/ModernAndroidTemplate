package com.auth.ui.login

import android.widget.Toast
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.lifecycle.viewmodel.compose.hiltViewModel
import com.auth.viewModels.LoginViewModel
import com.ui.components.LoadingOverlay
import com.ui.components.PrimaryButton

@Composable
fun LoginScreen(
    onLoginSuccess: () -> Unit
) {
    val viewModel: LoginViewModel = hiltViewModel()

    val uiState by viewModel.uiState.collectAsState()
    var email by remember { mutableStateOf("vascoda1@mailinator.com") }
    var password by remember { mutableStateOf("Test@123") }
    val context = LocalContext.current

    Box(modifier = Modifier.fillMaxSize()) {

        when (uiState) {
            is LoginUiState.Loading -> LoadingOverlay()
            is LoginUiState.Error -> Toast.makeText(context, (uiState as LoginUiState.Error).error, Toast.LENGTH_SHORT).show()
            is LoginUiState.Success -> {
                LaunchedEffect(Unit) { onLoginSuccess() }
            }
            else -> Unit
        }
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(24.dp),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(text = "Welcome", style = MaterialTheme.typography.headlineMedium)

            Spacer(modifier = Modifier.height(32.dp))

            OutlinedTextField(
                value = email,
                onValueChange = { email = it },
                label = { Text("Email") },
                modifier = Modifier.fillMaxWidth()
            )

            Spacer(modifier = Modifier.height(16.dp))

            OutlinedTextField(
                value = password,
                onValueChange = { password = it },
                label = { Text("Password") },
                visualTransformation = PasswordVisualTransformation(),
                modifier = Modifier.fillMaxWidth()
            )

            Spacer(modifier = Modifier.height(32.dp))

            PrimaryButton(
                text = "Login",
                onClick = { viewModel.login(email, password) },
                enabled = uiState !is LoginUiState.Loading
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun LoginScreenPreview() {
    MaterialTheme {
        LoginScreen(
            onLoginSuccess = {}
        )
    }
}