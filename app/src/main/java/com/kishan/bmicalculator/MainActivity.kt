package com.kishan.bmicalculator

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
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
                NavHost(navController = navController, startDestination = "bmi_screen"){
                    composable("bmi_screen"){
                        CalculatorScreen(navController = navController)
                    }
                    composable(
                        "result_screen/{argument}/{name}/{age}/{gender}",
                        arguments = listOf(
                            navArgument("argument") { type = NavType.StringType },
                            navArgument("name") { type = NavType.StringType },
                            navArgument("age"){type = NavType.StringType},
                            navArgument("gender"){type = NavType.StringType}
                        )
                    ){ backStackEntry ->
                        val argumentVal = backStackEntry.arguments?.getString("argument")
                        val nameVal = backStackEntry.arguments?.getString("name")
                        val ageVal = backStackEntry.arguments?.getString("age")
                        val genderVal = backStackEntry.arguments?.getString("gender")
                        if (argumentVal != null){
                            if (nameVal != null) {
                                if (ageVal != null) {
                                    if (genderVal != null) {
                                        ResultScreen(result = argumentVal, name = nameVal, age = ageVal,gender = genderVal, navController)
                                    }
                                }
                            }
                        }
                    }

                }

            }
        }
    }
}
