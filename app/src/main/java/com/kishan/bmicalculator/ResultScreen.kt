package com.kishan.bmicalculator

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.kishan.bmicalculator.common.ResultText


@Composable
fun ResultScreen(
    resultViewModel: MainViewModel = viewModel(),
    navController: NavController,
) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(
                color = Color(0xFF08101E)
            )
            .verticalScroll(rememberScrollState())
    ){
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 18.dp, start = 16.dp),
            ) {
                Text(
                    text = "Your BMI is",
                    style = TextStyle(
                        fontSize = 34.sp,
                        fontWeight = FontWeight.Bold,
                        fontFamily = FontFamily.SansSerif
                    ),
                    color = Color.White
                )
            }
            Spacer(modifier = Modifier.height(18.dp))

            Box(
                modifier = Modifier
                    .width(250.dp)
                    .height(250.dp)
                    .border(
                        width = 6.dp,
                        color = Color(0xFFC8C8C8),
                        shape = RoundedCornerShape(150.dp)
                    )
                    .padding(4.dp),
                contentAlignment = Alignment.Center
            ){
                Text(
                    text = resultViewModel.result,
                    color = Color.White,
                    style = TextStyle(
                        fontSize = 70.sp,
                        fontWeight = FontWeight(400),
                        fontFamily = FontFamily.SansSerif
                    )
                )
            }

            Spacer(modifier = Modifier.height(18.dp))

            Box(
                modifier = Modifier.fillMaxWidth(),
                contentAlignment = Alignment.Center
            ){
                Column(
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.spacedBy(4.dp)
                ) {
                    Spacer(modifier = Modifier.height(8.dp))
                    Text(
                        text = "Hi ${resultViewModel.userName}",
                        style = TextStyle(
                            fontSize = 28.sp,
                            fontWeight = FontWeight(500),
                            fontFamily = FontFamily.SansSerif,
                            color = Color.White
                        )
                    )
                    Spacer(modifier = Modifier.height(8.dp))
                    Text(
                        text = resultViewModel.userAge,
                        style = TextStyle(
                            fontSize = 28.sp,
                            fontWeight = FontWeight(500),
                            fontFamily = FontFamily.SansSerif,
                            color = Color.White
                        )
                    )
                    Spacer(modifier = Modifier.height(8.dp))
                    Text(
                        text = resultViewModel.gender,
                        style = TextStyle(
                            fontSize = 28.sp,
                            fontWeight = FontWeight(500),
                            fontFamily = FontFamily.SansSerif,
                            color = Color.White
                        )
                    )
                    Spacer(modifier = Modifier.height(8.dp))
                    if(resultViewModel.result.toFloat() < 18.5){
                        ResultText(resultText = "Under Weight", color = Color.Cyan)
                    }else if(resultViewModel.result.toFloat() in 18.5..24.9){
                        ResultText(resultText = "Normal Weight", color = Color.Green)
                    }else if(resultViewModel.result.toFloat() in 25.00..29.9) {
                        ResultText(resultText = "Over Weight", color = Color.Yellow)
                    }else if(resultViewModel.result.toFloat() in 30.00..34.9){
                        ResultText(resultText = "Obesity Class 1", color = Color(
                            1.0f,
                            0.349f,
                            0.0f,
                            1.0f
                            )
                        )
                    }else if(resultViewModel.result.toFloat() in 35.00..39.9){
                        ResultText(resultText = "Obesity Class 2", color = Color(
                            1.0f,
                            0.282f,
                            0.0f,
                            1.0f
                            )
                        )
                    }else if(resultViewModel.result.toFloat() >= 40.00){
                        ResultText(resultText = "Obesity Class 3", color = Color(
                            1.0f,
                            0.0f,
                            0.0f,
                            1.0f
                            )
                        )
                    }
                }
            }
            Spacer(modifier = Modifier.height(24.dp))
            Box(
                modifier = Modifier.fillMaxSize(),
                contentAlignment = Alignment.BottomCenter
            ) {
                Button(
                    onClick = {
                              navController.navigate("bmi_screen"){
                                  popUpTo(navController.graph.id){
                                      inclusive = true
                                  }
                              }
                        resultViewModel.reset()
                    },
                    contentPadding = PaddingValues(18.dp),
                    modifier = Modifier
                        .fillMaxWidth(0.9f)
                        .padding(bottom = 30.dp)
                        .background(
                            brush = Brush.linearGradient(
                                listOf(
                                    Color(0xC0002AFF),
                                    Color(0xD2FF0000)
                                )
                            ),
                            shape = RoundedCornerShape(38.dp)
                        ),
                    colors = ButtonDefaults.buttonColors(
                        containerColor = Color.Transparent
                    )
                ) {
                    Text(
                        text = "Calculate Again",
                        style = TextStyle(
                            fontSize = 28.sp,
                            fontWeight = FontWeight(700),
                            fontFamily = FontFamily.SansSerif,
                            color = Color.White
                        )
                    )
                }
            }
        }
    }
}

@Preview
@Composable
fun ResultScreenPrev() {
    ResultScreen(resultViewModel = MainViewModel(),navController = rememberNavController())
}