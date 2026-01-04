package com.example.mycanll.ui.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.mycanll.ui.screens.HomeScreen
import com.example.mycanll.ui.screens.DetailScreen

sealed class Screen(val route: String) {
    object Home : Screen("home")
    object Detail : Screen("detail")
}

@Composable
fun NavGraph(startDestination: String = Screen.Home.route) {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = startDestination) {
        composable(Screen.Home.route) {
            HomeScreen(onNavigateToDetail = { navController.navigate(Screen.Detail.route) })
        }
        composable(Screen.Detail.route) {
            DetailScreen(onBack = { navController.popBackStack() })
        }
    }
}
