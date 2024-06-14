package com.jimd.crudkotlincompose.ui.theme.ui.update

sealed class NotasUpdateEvent {
    data class onChangeTitulo(val titulo:String):NotasUpdateEvent()
    data class onChangeNota(val nota:String):NotasUpdateEvent()
    data class onChangeId(val id:Int):NotasUpdateEvent()
    data class onIdEtiqueta(val idEtiqueta:Int):NotasUpdateEvent()
    object update:NotasUpdateEvent()

}