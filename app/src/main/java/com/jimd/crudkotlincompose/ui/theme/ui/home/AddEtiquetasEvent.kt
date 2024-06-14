package com.jimd.crudkotlincompose.ui.theme.ui.home

sealed class AddEtiquetasEvent {
    data class changeEtiqueta(val etiqueta:String):AddEtiquetasEvent()
    data class notaABorrar(val id:Int):AddEtiquetasEvent()
    data class etiquetaSeleccionada(val idEtiqueta:Int):AddEtiquetasEvent()
    object saveEtiqueta:AddEtiquetasEvent()

    object deleteNota:AddEtiquetasEvent()
}