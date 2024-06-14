package com.jimd.crudkotlincompose.ui.theme.ui.add

import android.annotation.SuppressLint
import android.widget.Toast
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.KeyboardArrowLeft
import androidx.compose.material.icons.rounded.Done
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Dialog
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import com.example.myfirsappincomposeinnewinstalation.utils.MyButtonNormal
import com.example.myfirsappincomposeinnewinstalation.utils.MyEditTextCustomText
import com.jimd.crudkotlincompose.ui.theme.ui.home.AddEtiquetasEvent
import com.jimd.crudkotlincompose.ui.theme.ui.home.NotasHomeViewModel
import com.jimd.crudkotlincompose.ui.theme.ui.home.StateHome

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
    LaunchedEffect(key1 = Unit){
        viewModel.getAllEtiquetas()
    }
    var agregandoEtiqueta by rememberSaveable {
        mutableStateOf(false)
    }
    val state = viewModel.stateAdd
    val contexto = LocalContext.current
    alertaAddEtiqueta(state,valido = agregandoEtiqueta, onDismissRequest = { agregandoEtiqueta = false }, viewModel = viewModel) {
        viewModel.onEvent(NotasEvent.saveEtiqueta)
    }
    Box(modifier = Modifier
        .fillMaxSize()
        .padding(paddingValues)){
        Column(modifier=Modifier.fillMaxWidth()) {
            Row(modifier=Modifier.fillMaxWidth()) {
                LazyRow(modifier= Modifier
                    .fillMaxWidth()
                    .weight(1f)){
                    items(state.etiquetas){
                        Button(onClick = {
                            viewModel.onEvent(NotasEvent.onChangeEtiqueta(it.id))
                            Toast.makeText(contexto,"Esto ${it.id}",Toast.LENGTH_LONG).show()
                        }) {
                            Text(text = it.detalle)
                        }
                    }
                    item {
                        IconButton(onClick = { agregandoEtiqueta = true }, modifier = Modifier) {
                            Icon(imageVector = Icons.Default.Add, contentDescription = "")
                        }
                    }
                }
            }
            MyEditTextCustomText(modifier = Modifier,text = state.titulo, label = "Titulo", onValueChange = {
                viewModel.onEvent(NotasEvent.onChangeTitulo(it))
            })
            MyEditTextCustomText(modifier = Modifier.fillMaxSize(),text = state.nota, label = "Nota", onValueChange = {
                viewModel.onEvent(NotasEvent.onChangeNota(it))
            })
        }
    }
}

@Composable
fun alertaAddEtiqueta(
    state: NotaState,
    valido: Boolean,
    onDismissRequest: () -> Unit,
    viewModel: NotasViewModel,
    onConfirm: () -> Unit
){
    if (valido){
        Dialog(onDismissRequest = { onDismissRequest() }) {
            Card(colors = CardDefaults.cardColors(MaterialTheme.colorScheme.onSecondary)) {
                Column(modifier= Modifier
                    .fillMaxWidth()
                    .padding(15.dp)) {
                    Text(text = "Agregar Etiqueta")
                    MyEditTextCustomText(text = state.newEtiqueta, label = "Etiqueta", onValueChange = {
                        viewModel.onEvent(NotasEvent.newEtiqueta(it))
                    }, modifier = Modifier.fillMaxWidth())
                    MyButtonNormal(texto = "Agregar") {
                        onConfirm()
                        onDismissRequest()
                    }
                }
            }

        }
    }
}