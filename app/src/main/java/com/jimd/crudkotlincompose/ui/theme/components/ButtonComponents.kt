package com.example.myfirsappincomposeinnewinstalation.utils

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.jimd.crudkotlincompose.R

//@Preview(showBackground = true)
@Composable

//.clip(CircleShape)
fun MyButtonNormal(texto:String,onClick:()->Unit,){
    Box(modifier = Modifier
        .background(Color.Black)
        .padding(start = 35.dp, end = 35.dp)
        .height(50.dp)
        .clickable { onClick() },
        contentAlignment = Alignment.Center){
        Row(modifier = Modifier
            .fillMaxWidth()
            .align(alignment = Alignment.Center),
            verticalAlignment = Alignment.CenterVertically) {
            Text(text = texto,modifier = Modifier
                .padding(10.dp)
                .weight(1f),
                textAlign = TextAlign.Center,
                fontSize = 16.sp,
                fontWeight = FontWeight.Bold,
                color = Color.White)
            Image(painter = painterResource(id = R.drawable.arrow_forward),
                contentDescription = "Button",modifier= Modifier
                    .width(35.dp)
                    .height(35.dp))
        }
    }
}

@Composable
fun MyButton(
    texto: String,
    modifier: Modifier=Modifier,
    onClick: () -> Unit
){
    Button(onClick = { onClick() },modifier=modifier.fillMaxWidth(),
        shape = RoundedCornerShape(12.dp),
        elevation = ButtonDefaults.buttonElevation(4.dp),
        contentPadding = PaddingValues(start=35.dp,end=35.dp,top=20.dp, bottom = 20.dp)
        ) {
        Row {
            //Icon(Icons.Filled.ArrowForward, contentDescription = "")
            Text(text = texto)
        }

    }
}