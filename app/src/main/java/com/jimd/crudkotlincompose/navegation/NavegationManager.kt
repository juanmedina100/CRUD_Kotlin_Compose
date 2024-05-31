package com.jimd.crudkotlincompose.navegation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.jimd.crudkotlincompose.ui.theme.ui.add.notasApp
import com.jimd.crudkotlincompose.ui.theme.ui.home.notasHome
import com.jimd.crudkotlincompose.ui.theme.ui.update.notasUpdate

@Composable
fun navegationManager(navController: NavHostController){
    NavHost(navController = navController, startDestination = Routes.main.routes){
        composable(Routes.main.routes){ notasHome(navController) }
        composable(Routes.add.routes){ notasApp(navController) }
        composable(Routes.update.routes+"/{id}",
            arguments = listOf(navArgument("id"){ type = NavType.StringType })
            ){
            notasUpdate(it.arguments?.getString("id").orEmpty(),navController) }
    }
}