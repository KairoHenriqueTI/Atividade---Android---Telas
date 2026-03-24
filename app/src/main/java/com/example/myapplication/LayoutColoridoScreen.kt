package com.example.myapplication

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun LayoutColoridoScreen(onBack: () -> Unit) {
    Box(modifier = Modifier.fillMaxSize()) {
        Column(modifier = Modifier.fillMaxSize()) {
            // Header
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(Color(0xFF1976D2))
                    .padding(16.dp),
                contentAlignment = Alignment.CenterStart
            ) {
                Text("Modern Art UI", color = Color.White, fontSize = 18.sp, fontWeight = FontWeight.Bold)
            }

            // Main layout
            Row(modifier = Modifier.fillMaxSize()) {
                // Left side - Column 1
                Column(modifier = Modifier.weight(1f)) {
                    // Blue box
                    Box(
                        modifier = Modifier
                            .weight(2f)
                            .fillMaxWidth()
                            .background(Color(0xFF6B8DD6))
                    )

                    // Pink box
                    Box(
                        modifier = Modifier
                            .weight(1f)
                            .fillMaxWidth()
                            .background(Color(0xFFEA5A7E))
                    )
                }

                // Right side - Column 2
                Column(modifier = Modifier.weight(1f)) {
                    // Red box
                    Box(
                        modifier = Modifier
                            .weight(1f)
                            .fillMaxWidth()
                            .background(Color(0xFFC62828))
                    )

                    // Light gray box
                    Box(
                        modifier = Modifier
                            .weight(1f)
                            .fillMaxWidth()
                            .background(Color(0xFFE0E0E0))
                    )

                    // Dark blue box
                    Box(
                        modifier = Modifier
                            .weight(1f)
                            .fillMaxWidth()
                            .background(Color(0xFF1A237E))
                    )
                }
            }
        }
    }
}
