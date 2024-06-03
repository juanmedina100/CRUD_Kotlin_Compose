package com.jimd.crudkotlincompose.ui.theme.ui.add

import com.jimd.crudkotlincompose.data.entities.NotasEntity
import java.util.Date

data class NotaState(
    val titulo:String="",
    val nota:String="",
    val idNota:Int = 0,
    val fecha_creada: Date = Date(),
    val isLoadin:Boolean = false,
    val notas:List<NotasEntity> = emptyList(),
    val estado:Boolean = false
)
