package com.jimd.crudkotlincompose.ui.theme.ui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import androidx.navigation.compose.rememberNavController
import com.jimd.crudkotlincompose.navegation.navegationManager
import com.jimd.crudkotlincompose.ui.theme.CRUDKotlinComposeTheme
import com.jimd.crudkotlincompose.ui.theme.ui.home.notasHome
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            CRUDKotlinComposeTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    val navControler = rememberNavController()
                    navegationManager(navController = navControler)
                }
            }
        }
    }
}
//@Preview(showSystemUi = true)
//@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
//@Composable
//fun pruebaCompose(){
//    Scaffold {
//        prueba()
//    }
//}
//@Composable
//fun prueba(){
//
//    val myLista = listOf<String>("Juan","Israel","Medina","Diaz")
//    Box(modifier = Modifier.fillMaxSize()){
//        Column {
//            LazyColumn{
//                items(myLista){
//                    itemsList(lista = it)
//                }
//            }
//        }
//    }
//}
//@Composable
//fun itemsList(lista:String){
//    Column {
//        Text(text = lista)
//    }
//}
//suspend fun main(){
//    val cliente = HttpClient(CIO)
//    val response = cliente.get("https://juanmedina100.github.io/paises/paises.json")
//    println(response.status)
//    println(response.version)
//    val ipolito = response.body<String>()
//    println(ipolito)
//    cliente.close()
//}