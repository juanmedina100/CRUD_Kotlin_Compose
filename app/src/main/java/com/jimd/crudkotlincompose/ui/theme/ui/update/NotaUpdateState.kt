package com.jimd.crudkotlincompose.ui.theme.ui.update

import com.jimd.crudkotlincompose.data.entities.NotasEntity
import java.util.Date

data class NotaUpdateState(
    val id:Int=0,
    val titulo:String="",
    val nota:String="",
    val fecha_creada: Date = Date(),
    val isLoadin:Boolean = false,
    val notas:List<NotasEntity> = emptyList(),
    val estado:Boolean = false,
    val idEtiqueta:Int=0
)
