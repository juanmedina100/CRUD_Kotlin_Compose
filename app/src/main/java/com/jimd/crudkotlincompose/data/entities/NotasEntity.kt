package com.jimd.crudkotlincompose.data.entities

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.util.Date

@Entity
data class NotasEntity(
    @PrimaryKey(autoGenerate = true)
    val id:Int,
    val titulo:String,
    val nota:String,
    val fecha_creada:Date
)
