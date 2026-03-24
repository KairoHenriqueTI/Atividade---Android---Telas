package com.example.myapplication

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.myapplication.ui.theme.MyApplicationTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            MyApplicationTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    MainNavigation(modifier = Modifier.padding(innerPadding))
                }
            }
        }
    }
}

@Composable
fun MainNavigation(modifier: Modifier = Modifier) {
    val currentScreen = remember { mutableStateOf(0) }

    when (currentScreen.value) {
        0 -> ExercisesMenuScreen(onSelectExercise = { currentScreen.value = it })
        1 -> Box {
            UILabsScreen()
            BackButton { currentScreen.value = 0 }
        }
        2 -> Box {
            LayoutColoridoScreen { currentScreen.value = 0 }
            BackButton { currentScreen.value = 0 }
        }
        3 -> Box {
            CategoriesScreen { currentScreen.value = 0 }
            BackButton { currentScreen.value = 0 }
        }
        4 -> Box {
            ChattScreen { currentScreen.value = 0 }
            BackButton { currentScreen.value = 0 }
        }
        5 -> Box {
            MyApplicationFormScreen { currentScreen.value = 0 }
            BackButton { currentScreen.value = 0 }
        }
        6 -> Box {
            TheCaldwellScreen { currentScreen.value = 0 }
            BackButton { currentScreen.value = 0 }
        }
        7 -> Box {
            BosViagemScreen { currentScreen.value = 0 }
            BackButton { currentScreen.value = 0 }
        }
    }
}

@Composable
fun BackButton(onClick: () -> Unit) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .background(Color(0xFF1976D2))
            .padding(8.dp)
            .clickable { onClick() },
        contentAlignment = Alignment.CenterStart
    ) {
        Text("← Voltar", color = Color.White, fontWeight = FontWeight.Bold, fontSize = 16.sp)
    }
}
