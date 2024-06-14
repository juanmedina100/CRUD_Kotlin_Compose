package com.jimd.crudkotlincompose.ui.theme.ui.home

import com.jimd.crudkotlincompose.data.repository.model.EtiquetasModelAll
import com.jimd.crudkotlincompose.data.repository.model.NotasModelAll

data class StateHome(
    val isLoading:Boolean = false,
    val notas:List<NotasModelAll> = emptyList(),
    val id:Int=0,
    val idEtiqueta:Int=0,
    val titulo:String="",
    val nota:String="",
    val etiquetasEnDb:Int = 0,
    val etiquetas:List<EtiquetasModelAll> = emptyList(),
    val newEtiqueta:String="",
    val idABorrar:Int=0
)
