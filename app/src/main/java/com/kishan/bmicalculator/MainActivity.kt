package com.kishan.bmicalculator

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.kishan.bmicalculator.ui.theme.BMICalculatorTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            BMICalculatorTheme {
                // A surface container using the 'background' color from the theme
                val navController = rememberNavController()
                //most important to provide viewModels() in your activity
                val viewModel : MainViewModel by viewModels()
                NavHost(navController = navController, startDestination = "bmi_screen"){
                    composable("bmi_screen"){
                        CalculatorScreen(navController = navController, viewModel = viewModel)
                    }
                    composable(
                        "result_screen",
                    ){
                        ResultScreen(resultViewModel = viewModel ,navController = navController)
                    }
                }
            }
        }
    }
}
