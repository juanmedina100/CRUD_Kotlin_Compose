package com.jimd.crudkotlincompose.ui.theme.ui.add

import com.jimd.crudkotlincompose.data.entities.NotasEntity
import com.jimd.crudkotlincompose.data.repository.model.EtiquetasModelAll
import com.jimd.crudkotlincompose.data.repository.model.NotasModelAll
import java.util.Date

data class NotaState(
    val titulo:String="",
    val nota:String="",
    val idEtiqueta:Int = 0,
    val fecha_creada: Date = Date(),
    val isLoadin:Boolean = false,
    val notas:List<NotasModelAll> = emptyList(),
    val etiquetas:List<EtiquetasModelAll> = emptyList(),
    val estado:Boolean = false,
    val newEtiqueta:String="",
    val idABorrar:Int=0
)
