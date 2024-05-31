package com.jimd.crudkotlincompose.data.db

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.jimd.crudkotlincompose.data.dao.NotasDao
import com.jimd.crudkotlincompose.data.entities.EtiquetaEntity
import com.jimd.crudkotlincompose.data.entities.NotasEntity
import com.jimd.crudkotlincompose.utils.DateConverter

@Database(
    entities = [NotasEntity::class,EtiquetaEntity::class],
    version = 1,
    exportSchema = false
)
@TypeConverters(DateConverter::class)
abstract class NotasDatabase :RoomDatabase(){
    abstract fun notasDao():NotasDao
}