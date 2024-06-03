package com.jimd.crudkotlincompose.data.entities

import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.Relation
import java.util.Date

@Entity
data class NotasEntity(
    @PrimaryKey(autoGenerate = true)
    val id:Int,
    val titulo:String,
    val nota:String,
    val idEtiqueta:Int,
    val fecha_creada:Date
)
