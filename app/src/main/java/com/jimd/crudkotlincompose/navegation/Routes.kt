package com.jimd.crudkotlincompose.navegation

sealed class Routes(val routes:String){
    object main:Routes("main")
    object add:Routes("add")
    object update:Routes("update/{id}")
}
