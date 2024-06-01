package com.jimd.crudkotlincompose.ui.theme.ui.home

import android.annotation.SuppressLint
import android.net.Uri
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.rounded.Delete
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Divider
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
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.window.Dialog
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import com.jimd.crudkotlincompose.data.entities.NotasEntity
import com.jimd.crudkotlincompose.navegation.Routes

@OptIn(ExperimentalMaterial3Api::class)
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun notasHome(navController: NavHostController) {
    Scaffold(
        topBar = {
            TopAppBar(title = { Text(text = "CRUD Notas Compose") }, actions = {
                IconButton(onClick = { navController.navigate(Routes.add.routes) }) {
                    Icon(imageVector = Icons.Default.Add, contentDescription = "")
                }
            })
        }
    ) {
        myNotasHome(it,navController)
    }
}

@Composable
fun myNotasHome(paddingValues: PaddingValues,navController: NavController,viewModel: NotasHomeViewModel= hiltViewModel()){
    LaunchedEffect(key1 = Unit){
        viewModel.getAllNotas()
    }
    val state = viewModel.stateHome
    Box(modifier = Modifier
        .fillMaxSize()
        .padding(paddingValues)
        .padding(10.dp)){
        LazyColumn{
            items(state.notas){
                myItemHome(it,navController)
            }
        }
    }
}
@Composable
fun myItemHome(notasEntity: NotasEntity, navController: NavController,viewModel: NotasHomeViewModel= hiltViewModel()) {

    var validacion by rememberSaveable {
        mutableStateOf(false)
    }
    alertaBorrar(valido = validacion,{ validacion = false}, onConfirm = { viewModel.deleteNota() })
    Card(modifier= Modifier
        .fillMaxWidth()
        .padding(5.dp)
        .clickable {
            navController.navigate(Routes.update.routes + "/${Uri.encode(notasEntity.id.toString())}")
        }, colors = CardDefaults.cardColors(MaterialTheme.colorScheme.onSecondary),
        elevation = CardDefaults.cardElevation(2.dp)) {
        Column(modifier= Modifier
            .fillMaxWidth()
            .padding(10.dp)) {
            Row(modifier=Modifier.fillMaxWidth()) {
             Column(modifier=Modifier.weight(1f)) {
                 Text(text = notasEntity.titulo, modifier = Modifier.fillMaxWidth(), maxLines = 2, fontWeight = FontWeight.Bold)
                 Text(text = notasEntity.nota,modifier=Modifier.fillMaxWidth(), maxLines = 4)
             }
                IconButton(onClick = { 
                                     validacion = true
                                     }, modifier = Modifier.align(alignment = Alignment.CenterVertically)) {
                    Icon(imageVector = Icons.Rounded.Delete, contentDescription = "")
                }
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun alertaBorrar(valido:Boolean, onDismissRequest:()->Unit, onConfirm:()->Unit){
    if (valido){
        Dialog(onDismissRequest = { onDismissRequest() }) {
            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp), colors = CardDefaults.cardColors(MaterialTheme.colorScheme.onSecondary),
                elevation = CardDefaults.cardElevation(6.dp)
            ) {
            Column(modifier= Modifier
                .fillMaxWidth()
                .padding(20.dp)) {
                Text(
                    text = "Eliminar nota",
                    modifier = Modifier
                        .fillMaxWidth().padding(bottom = 15.dp)
                        .wrapContentSize(Alignment.Center),
                    textAlign = TextAlign.Center, fontWeight = FontWeight.Bold, fontSize = 18.sp
                )
                Text(
                    text = "Estas seguro de eliminar esta nota",
                    modifier = Modifier
                        .fillMaxWidth()
                        .wrapContentSize(Alignment.Center),
                    textAlign = TextAlign.Center,
                )
                Divider(modifier=Modifier.padding(vertical = 25.dp))
                Row {
                    Text(text = "Cancelar",modifier= Modifier
                        .fillMaxWidth().weight(0.1f)
                        .clickable {
                            onDismissRequest()
                        }, textAlign = TextAlign.End)
                    Text(text = "Confirmar",modifier= Modifier
                        .fillMaxWidth().weight(0.1f)
                        .clickable {
                            onConfirm()
                            onDismissRequest()
                        }, textAlign = TextAlign.End)
                }

            }
            }
        }
    }
}
