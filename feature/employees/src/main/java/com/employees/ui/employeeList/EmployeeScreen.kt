package com.employees.ui.employeeList

import android.util.Log
import android.widget.Toast
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.hilt.lifecycle.viewmodel.compose.hiltViewModel
import com.domain.model.Employee
import com.employees.viewModels.EmployeeViewModel
import com.ui.components.LoadingOverlay


@Composable
fun EmployeeScreen() {
    val viewModel: EmployeeViewModel = hiltViewModel()
    val uiState by viewModel.uiState.collectAsState()
    val context = LocalContext.current

    when (val state = uiState) {
        is EmployeeScreenUiState.Loading -> LoadingOverlay()
        is EmployeeScreenUiState.Error -> Toast.makeText(context, (uiState as EmployeeScreenUiState.Error).error, Toast.LENGTH_SHORT).show()
        is EmployeeScreenUiState.Success -> {
            LazyColumn(
                modifier = Modifier.fillMaxSize()
            ) {
                Log.i("DHANA", state.toString())
                items(state.employees) { employee ->
                    EmployeeItem(
                        employee = employee,
                        onClick = {
                            Toast.makeText(
                                context,
                                employee.fullName,
                                Toast.LENGTH_SHORT
                            ).show()
                        }
                    )
                }
            }
        }
        else -> Unit
    }


}

@Composable
fun EmployeeItem(
    employee: Employee,
    modifier: Modifier = Modifier,
    onClick: (Employee) -> Unit = {}
) {
    Card(
        modifier = modifier
            .fillMaxWidth()
            .padding(horizontal = 12.dp, vertical = 6.dp)
            .clickable { onClick(employee) },
        elevation = CardDefaults.cardElevation(defaultElevation = 4.dp)
    ) {
        Column(modifier = Modifier.padding(16.dp)) {
            Text(
                text = employee.fullName,
                style = MaterialTheme.typography.titleMedium
            )

            Spacer(modifier = Modifier.height(4.dp))

            Text(
                text = "Phone: ${employee.phone}",
                style = MaterialTheme.typography.bodyMedium
            )

            Text(
                text = "Position: ${employee.position}",
                style = MaterialTheme.typography.bodySmall
            )
        }
    }
}