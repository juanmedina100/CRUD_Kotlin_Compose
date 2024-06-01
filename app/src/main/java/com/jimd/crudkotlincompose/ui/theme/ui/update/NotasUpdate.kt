package com.jimd.crudkotlincompose.ui.theme.ui.update

import android.annotation.SuppressLint
import android.net.Uri
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.KeyboardArrowLeft
import androidx.compose.material.icons.rounded.Done
import androidx.compose.material.icons.rounded.ThumbUp
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
import com.example.myfirsappincomposeinnewinstalation.utils.MyEditTextCustomText
import com.jimd.crudkotlincompose.ui.theme.ui.add.NotasEvent
import com.jimd.crudkotlincompose.ui.theme.ui.add.NotasViewModel

@OptIn(ExperimentalMaterial3Api::class)
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun notasUpdate(id:String,navController: NavController, viewModel: NotasUpdateViewModel = hiltViewModel()){
    val myId = Uri.decode(id).toInt()
    Scaffold(
        topBar = {
            TopAppBar(title = { Text(text = "Actualizar nota",modifier= Modifier.fillMaxWidth(),
                textAlign = TextAlign.Center) },
                actions = {
                    IconButton(onClick = {
                        viewModel.onEvent(NotasUpdateEvent.update)
                        navController.popBackStack()
                    }) {
                        Icon(imageVector = Icons.Rounded.ThumbUp, contentDescription = "")
                    }
            }, navigationIcon = {
                IconButton(onClick = { navController.popBackStack() }) {
                    Icon(imageVector = Icons.Default.KeyboardArrowLeft, contentDescription = "")
                }
                })
        }
    ) {
        myNotasApp(it,myId)
    }
}
@Composable
fun myNotasApp(
    paddingValues: PaddingValues,
    id:Int,
    viewModel: NotasUpdateViewModel = hiltViewModel()
){
    LaunchedEffect(key1 = Unit){
        viewModel.getNotaForId(id.toInt())
    }
    val state = viewModel.stateUpdate
    Box(modifier = Modifier
        .fillMaxSize()
        .padding(paddingValues)){
        Column(modifier= Modifier.fillMaxWidth()) {
            MyEditTextCustomText(modifier = Modifier,text = state.titulo, label = "Titulo", onValueChange = {
                viewModel.onEvent(NotasUpdateEvent.onChangeTitulo(it))
                viewModel.onEvent(NotasUpdateEvent.onChangeId(id))
            })
            MyEditTextCustomText(modifier = Modifier.fillMaxSize(),text = state.nota, label = "Nota", onValueChange = {
                viewModel.onEvent(NotasUpdateEvent.onChangeNota(it))
                viewModel.onEvent(NotasUpdateEvent.onChangeId(id))
            })
        }
    }
}