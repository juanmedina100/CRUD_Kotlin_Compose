package com.jimd.crudkotlincompose.ui.theme.ui.add

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowLeft
import androidx.compose.material.icons.rounded.Done
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.style.TextAlign
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import com.example.myfirsappincomposeinnewinstalation.utils.MyEditTextCustomText

@OptIn(ExperimentalMaterial3Api::class)
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun notasApp(navController: NavController,viewModel: NotasViewModel = hiltViewModel()){
    Scaffold(
        topBar = {
            TopAppBar(title = { Text(text = "Agregar nota",modifier=Modifier.fillMaxWidth(), textAlign = TextAlign.Center) }, actions = {
                if (viewModel.stateAdd.estado){
                IconButton(onClick = {
                    viewModel.onEvent(NotasEvent.save)
                    navController.popBackStack()
                }) {
                        Icon(imageVector = Icons.Rounded.Done, contentDescription = "")
                    }
                }
            },
                navigationIcon = {
                    IconButton(onClick = { navController.popBackStack() }) {
                        Icon(imageVector = Icons.Default.KeyboardArrowLeft, contentDescription = "")
                    }
                }
                )
        }
    ) {
        myNotasApp(it)
    }
}
@Composable
fun myNotasApp(
    paddingValues: PaddingValues,
    viewModel: NotasViewModel = hiltViewModel()
){
    val state = viewModel.stateAdd
    Box(modifier = Modifier
        .fillMaxSize()
        .padding(paddingValues)){
        Column(modifier=Modifier.fillMaxWidth()) {
            MyEditTextCustomText(modifier = Modifier,text = state.titulo, label = "Titulo", onValueChange = {
                viewModel.onEvent(NotasEvent.onChangeTitulo(it))
            })
            MyEditTextCustomText(modifier = Modifier.fillMaxSize(),text = state.nota, label = "Nota", onValueChange = {
                viewModel.onEvent(NotasEvent.onChangeNota(it))
            })
        }
    }
}