package com.kishan.bmicalculator.common

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp

@Composable
fun ResultText(
    resultText:String,
    color : Color
) {
    Text(
        text = resultText,
        color = color,
        style = TextStyle(
            fontSize = 34.sp,
            fontWeight = FontWeight(700),
            fontFamily = FontFamily.SansSerif
        ),
    )
}