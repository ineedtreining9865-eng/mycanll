package com.example.mycanll

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.example.mycanll.ui.theme.MycanllTheme
import com.example.mycanll.ui.navigation.NavGraph

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MycanllTheme {
                // Set up the navigation host
                NavGraph()
            }
        }
    }
}
