package com.kishan.bmicalculator.common



import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun EditTextField(
    placeHolder : String,
    value:String,
    onChangeValue : (String)->Unit,
    keyboardOptions: KeyboardOptions,
    isError: Boolean
) {
    TextField(
        value = value,
        onValueChange = onChangeValue,
        placeholder = {
            Text(
                text = placeHolder,
                color = Color(0xA5FFFFFF),
                fontSize = 24.sp
            )
        },
        colors = TextFieldDefaults.textFieldColors(
            containerColor = Color(0xFF5E5C7E),
            cursorColor = Color.White
        ),
        shape = RoundedCornerShape(4.dp,60.dp,4.dp, 12.dp),
        modifier = Modifier.fillMaxWidth(),
        singleLine = true,
        textStyle = TextStyle(
            color = Color.White,
            fontSize = 24.sp
        ),
        keyboardOptions = keyboardOptions,
        isError = isError

    )
}

@Preview
@Composable
fun EditTextFieldPrev() {
    var text by remember { mutableStateOf("")}
    EditTextField(
        placeHolder = "Height",
        value = text,
        onChangeValue = {
            text = it
        },
        keyboardOptions = KeyboardOptions(
            keyboardType = KeyboardType.Number
        ),
        isError = text.isNotEmpty()
    )
}

