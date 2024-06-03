package com.jimd.crudkotlincompose.data.entities

import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey
import java.util.Date

@Entity
data class EtiquetaEntity(
    @PrimaryKey(autoGenerate = true)
    val id:Int,
    val detalle:String,
    val fecha_creada:Date
)
