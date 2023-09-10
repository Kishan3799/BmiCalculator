package com.kishan.bmicalculator


import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import java.math.RoundingMode
import java.text.DecimalFormat

class MainViewModel : ViewModel() {

    var userName by mutableStateOf("")
    var userAge by mutableStateOf("")
    var height by mutableStateOf("")
    var weight by mutableStateOf("")
    var gender by mutableStateOf("")
    var result by mutableStateOf("")

    var isSelectMale by mutableStateOf(false)
    var isSelectFemale by mutableStateOf(false)
    var enableButton by mutableStateOf(false)



    init {
        reset()
    }

    fun updateName(inputUserName : String){
        userName = inputUserName
    }

    fun updateAge(inputUserAge : String){
        userAge = inputUserAge
    }

    fun updateHeight(input :String){
        height = input
    }

    fun updateWeight(input : String){
        weight = input
    }

    fun updateGender(input: String) : String{
        gender = input
        return gender
    }


    fun calculateBmiIndex(){
        val userHeight = height.toDoubleOrNull()
        val userWeight = weight.toDoubleOrNull()

        if(userHeight != null && userWeight != null){
            val bmi = userWeight/((userHeight/100) * (userHeight/100))
            val df = DecimalFormat("#.##")
            df.roundingMode = RoundingMode.DOWN
            result = df.format(bmi)
        }else {
            result = "Invalid value"
        }
    }

    fun reset(){
        height =""
        userName = ""
        userAge = ""
        weight = ""
        gender = ""
        isSelectMale = false
        isSelectFemale = false
        enableButton = false
    }

    fun checkAllFieldIsFilled() : Boolean {
        if( height.isNotEmpty() && weight.isNotEmpty() && userName.isNotEmpty() && userAge.isNotEmpty() && (isSelectMale || isSelectFemale)){
            enableButton = true
            return true
        }
        return false
    }
}