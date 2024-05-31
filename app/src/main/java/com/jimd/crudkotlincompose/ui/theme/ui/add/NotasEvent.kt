package com.jimd.crudkotlincompose.ui.theme.ui.add

sealed class NotasEvent {
    data class onChangeTitulo(val titulo:String):NotasEvent()
    data class onChangeNota(val nota:String):NotasEvent()
    object save:NotasEvent()
}