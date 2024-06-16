package com.example.myfirsappincomposeinnewinstalation.utils

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.CutCornerShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldColors
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MyEditTextNormal(texto: String, label: String) {
    var text by rememberSaveable {
        mutableStateOf("")
    }
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(5.dp)
    ) {
        OutlinedTextField(
            value = text,
            onValueChange = { text = it },
            label = { Text(text = label) },
            modifier = Modifier
                .fillMaxWidth()
                .padding(5.dp),
            shape = CutCornerShape(15.dp)
        )
    }

}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MyEditTextNormal2(value: String, label: String, onValueChange: (String) -> Unit) {
//    var value by rememberSaveable {
//        mutableStateOf("")
//    }
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(5.dp)
    ) {
        OutlinedTextField(
            value = value,
            onValueChange = { onValueChange },
            label = { Text(text = label) },
            modifier = Modifier
                .fillMaxWidth()
                .padding(5.dp),
            shape = CutCornerShape(15.dp)
        )
    }

}

@OptIn(ExperimentalMaterial3Api::class)
@Preview(showSystemUi = true)
@Composable
fun MyTextFielBasic() {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(2.dp)
            .background(brush = Brush.horizontalGradient(colors = listOf(Color.Blue, Color.Green)))
    ) {
        OutlinedTextField(
            value = "", onValueChange = {  },
            modifier = Modifier
                .fillMaxWidth()
                .padding(10.dp)
                .height(60.dp)
                .background(Color.Transparent),
            textStyle = TextStyle(Color.Black, fontSize = 20.sp),
            shape = RoundedCornerShape(22.dp),
            label = { Text(text = "Nombre") },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text)
        )
    }

}


//@Preview(showSystemUi = true)
@Composable
fun myPrevi() {
    MyEditTextNormal(texto = "Hello", label = "Nombre")
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MyEditTextCustomText(text:String,label: String, onValueChange: (String) -> Unit,modifier: Modifier,fontSize: TextUnit){
Column(modifier = modifier.fillMaxWidth()) {
    OutlinedTextField(
        value = text, onValueChange = onValueChange,
        modifier = modifier
            .fillMaxWidth()
            .padding(top = 5.dp, start = 10.dp, end = 10.dp, bottom = 5.dp)
            .height(70.dp)
            .background(Color.Transparent),
        textStyle = TextStyle(Color.Black, fontSize = fontSize),
        shape = RoundedCornerShape(12.dp),
        label = { Text(text = label) },
//        colors = TextFieldDefaults.colors(
//            focusedContainerColor = Color.Green,
//            unfocusedContainerColor = Color.Red,
//            focused
//        ),
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text)
    )
}
}