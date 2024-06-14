package com.jimd.crudkotlincompose.ui.theme.ui.add

sealed class NotasEvent {
    data class onChangeTitulo(val titulo:String):NotasEvent()
    data class onChangeNota(val nota:String):NotasEvent()
    data class onChangeEtiqueta(val idEtiqueta:Int):NotasEvent()
    data class newEtiqueta(val Etiqueta:String):NotasEvent()
    object saveEtiqueta:NotasEvent()
    object save:NotasEvent()
}