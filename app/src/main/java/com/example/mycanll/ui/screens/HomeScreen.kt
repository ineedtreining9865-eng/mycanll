package com.example.mycanll.ui.screens

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Info
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.mycanll.viewmodel.MainViewModel
import androidx.lifecycle.viewmodel.compose.viewModel

@Composable
fun HomeScreen(
    onNavigateToDetail: () -> Unit,
    viewModel: MainViewModel = viewModel()
) {
    val expression = viewModel.expression.collectAsState()
    val result = viewModel.result.collectAsState()

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Calculator") },
                actions = {
                    IconButton(onClick = onNavigateToDetail) {
                        Icon(Icons.Default.Info, contentDescription = "Info")
                    }
                }
            )
        }
    ) { paddingValues ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues)
                .padding(16.dp)
        ) {
            // Expression display
            Text(
                text = expression.value,
                style = MaterialTheme.typography.headlineMedium,
                modifier = Modifier.fillMaxWidth(),
                maxLines = 1
            )
            Spacer(modifier = Modifier.height(8.dp))
            // Result display
            Text(
                text = result.value,
                style = MaterialTheme.typography.headlineSmall,
                modifier = Modifier.fillMaxWidth(),
                maxLines = 1,
                fontWeight = FontWeight.Bold
            )
            Spacer(modifier = Modifier.height(24.dp))

            // Calculator buttons grid
            val buttonRows = listOf(
                listOf("C", "(", ")", "/"),
                listOf("7", "8", "9", "*"),
                listOf("4", "5", "6", "-"),
                listOf("1", "2", "3", "+"),
                listOf("0", ".", "=")
            )

            buttonRows.forEach { row ->
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.spacedBy(8.dp)
                ) {
                    row.forEach { label ->
                        Button(
                            onClick = { viewModel.onButtonPress(label) },
                            modifier = Modifier
                                .weight(1f)
                                .height(64.dp)
                        ) {
                            Text(label, fontSize = 20.sp)
                        }
                    }
                    // Fill remaining space if the row has less than 4 items
                    if (row.size < 4) {
                        repeat(4 - row.size) {
                            Spacer(modifier = Modifier.weight(1f))
                        }
                    }
                }
                Spacer(modifier = Modifier.height(8.dp))
            }
        }
    }
}
