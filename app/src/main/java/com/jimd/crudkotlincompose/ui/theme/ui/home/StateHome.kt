package com.jimd.crudkotlincompose.ui.theme.ui.home

import com.jimd.crudkotlincompose.data.entities.NotasEntity

data class StateHome(
    val isLoadin:Boolean = false,
    val notas:List<NotasEntity> = emptyList(),
    val id:Int=0,
    val titulo:String="",
    val nota:String=""
)
