package com.jimd.crudkotlincompose.ui.theme.ui.home

import android.annotation.SuppressLint
import android.net.Uri
import android.util.Log
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.rounded.Delete
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
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
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
            TopAppBar(title = { /*TODO*/ }, actions = {
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
        Log.i("LOLO","getallnotas-> ${viewModel.getAllNotas()}")
    }
    val state = viewModel.stateHome
    Log.i("LOLO","notas-> ${state.notas}")
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
                IconButton(onClick = { viewModel.deleteNota() }, modifier = Modifier.align(alignment = Alignment.CenterVertically)) {
                    Icon(imageVector = Icons.Rounded.Delete, contentDescription = "")
                }
            }
        }
    }
}