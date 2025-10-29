package com.example.first_movile_app

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.first_movile_app.screen.MainLayout
import com.example.first_movile_app.ui.theme.FirstmovileappTheme

class MainActivity : ComponentActivity() {
    @SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            FirstmovileappTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) {
                    MainLayout()
                }
            }
        }
    }
}


@Preview(showBackground = true)
@Composable
fun TaskPreview() {
    FirstmovileappTheme {
        MainLayout()
    }
}

