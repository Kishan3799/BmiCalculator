package com.kishan.bmicalculator


import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.kishan.bmicalculator.common.EditTextField
import com.kishan.bmicalculator.common.GenderChooseButton
import androidx.lifecycle.viewmodel.compose.viewModel
@Composable
fun CalculatorScreen(
    navController: NavController,
    viewModel: MainViewModel = viewModel(),
) {
    val isValid by rememberSaveable { mutableStateOf(false) }

    var isSelectMale by rememberSaveable {
        mutableStateOf(false)
    }
    var isSelectFemale by rememberSaveable {
        mutableStateOf(false)
    }

    Box(modifier = Modifier
        .fillMaxSize()
        .background(
            color = Color(0xFF08101E)
        )){
        Column(modifier = Modifier.fillMaxWidth()) {
            Text(
                text = "BMI Calculator",
                style = TextStyle(
                    fontSize = 28.sp,
                    fontWeight = FontWeight(700),
                    fontFamily = FontFamily.SansSerif,
                    color = Color(0xFF958CFF)
                ),
                modifier = Modifier.padding(start = 16.dp, top = 40.dp)
            )
            Text(
                text = "Are You",
                style = TextStyle(
                    fontSize = 24.sp,
                    fontWeight = FontWeight(600),
                    fontFamily = FontFamily.SansSerif,
                    color = Color.White,
                ),
                modifier = Modifier.padding(top = 16.dp, start = 16.dp)
            )
            Spacer(modifier = Modifier.height(16.dp))
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceAround
            ) {
                GenderChooseButton(
                    imageId = R.drawable.faceman,
                    isSelected = isSelectMale,
                    onClick = {
                        viewModel.updateGender("Male")
                        isSelectMale = true
                        isSelectFemale = false
                              },
                    selectedColor = if(isSelectMale){Color(0xFF00F2FF)
                    } else { Color(0x4D9A6A6A)}
                )
                GenderChooseButton(
                    imageId = R.drawable.facewoman,
                    isSelected = isSelectFemale,
                    onClick = {
                        viewModel.updateGender("Female")
                        isSelectFemale = true
                        isSelectMale = false
                              },
                    selectedColor = if(isSelectFemale){Color(0xFF00F2FF)
                    } else { Color(0x4D9A6A6A)}
                )
            }
            Spacer(modifier = Modifier.height(16.dp))
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .fillMaxHeight(0.8f)
                    .padding(16.dp),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.SpaceEvenly
            ) {
                EditTextField(
                    placeHolder = "Height in (Cm's)",
                    value = viewModel.height,
                    onChangeValue = { userHeight ->
                        viewModel.updateHeight(userHeight)
                    },
                    keyboardOptions = KeyboardOptions(
                        keyboardType = KeyboardType.Number,
                        imeAction = ImeAction.Next
                    ),
                    isError = !isValid
                )
                EditTextField(
                    placeHolder = "Weigh in (Kg's)",
                    value = viewModel.weight,
                    onChangeValue = { userWeight ->
                        viewModel.updateWeight(userWeight)
                    },
                    keyboardOptions = KeyboardOptions(
                        keyboardType = KeyboardType.Number,
                        imeAction = ImeAction.Next
                    ),
                    isError = !isValid
                )

                EditTextField(
                    placeHolder = "Your Name",
                    value = viewModel.userName,
                    onChangeValue = {name ->
                        viewModel.updateName(name)
                    },
                    keyboardOptions = KeyboardOptions(
                        keyboardType = KeyboardType.Text,
                        imeAction = ImeAction.Next
                    ),
                    isError = !isValid
                )

                EditTextField(
                    placeHolder = "Age",
                    value = viewModel.userAge,
                    onChangeValue = {age->
                        viewModel.updateAge(age)
                    },
                    keyboardOptions = KeyboardOptions(
                        keyboardType = KeyboardType.Number,
                        imeAction = ImeAction.Done
                    ),
                    isError = !isValid
                )
            }

            Box(
                modifier = Modifier.fillMaxWidth(),
                contentAlignment = Alignment.Center
            ) {
                Button(
                    onClick = {
                        viewModel.calculateBmiIndex()
                        navController.navigate("result_screen")
                    },
                    contentPadding = PaddingValues(18.dp),
                    modifier = Modifier
                        .fillMaxWidth(0.9f)
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
                        text = "Calculate BMI",
                        style = TextStyle(
                            fontSize = 28.sp,
                            fontWeight = FontWeight(700),
                            fontFamily = FontFamily.SansSerif,
                            color = Color(0xFFFFFFFF)
                        )
                    )
                }
            }
        }
    }
}


@Preview
@Composable
fun CalculatorScreenPreview() {
    CalculatorScreen(viewModel = MainViewModel() ,navController = rememberNavController())
}