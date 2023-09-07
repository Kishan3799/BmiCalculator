package com.kishan.bmicalculator.common

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.selection.selectable
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.semantics.Role
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.kishan.bmicalculator.R

@Composable
fun GenderChooseButton(
    imageId:Int,
    isSelected : Boolean = false,
    selectedColor:Color,
    onClick: () -> Unit
) {
    Card(
        modifier = Modifier
            .width(150.dp)
            .height(150.dp)
            .selectable(
                selected = isSelected,
                onClick = onClick,
                role = Role.RadioButton
            ),
        shape = RoundedCornerShape(3.dp),
        border = BorderStroke(3.dp, color = selectedColor),
        colors = CardDefaults.cardColors(
            containerColor = Color(0xFF3D2727)
        )
    ) {
        Box(
            modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
        ){
            Image(
                modifier = Modifier.size(90.dp),
                painter = painterResource(id = imageId),
                contentDescription = "male",
                contentScale = ContentScale.Crop
            )
        }

    }
}

@Preview
@Composable
fun GenderChooseButtonPrev() {
    var select = false
    if(select){
        GenderChooseButton(imageId = R.drawable.facewoman, select, onClick= {"Female"}, selectedColor =  Color(0xFF00FFDF))
    }else{
        GenderChooseButton(imageId = R.drawable.facewoman, select, onClick = {"Female"}, selectedColor = Color(0x4D9A6A6A))
    }

}











