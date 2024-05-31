package com.jimd.crudkotlincompose.domain

import androidx.room.Query
import com.jimd.crudkotlincompose.data.entities.NotasEntity
import kotlinx.coroutines.flow.Flow

interface NotasRepository {

    suspend fun insertNota(notasEntity: NotasEntity)

    fun getAllNotas():Flow<List<NotasEntity>>


    suspend fun notasUpdate(notasEntity: NotasEntity)

    suspend fun getNotaForId(id:Int):NotasEntity

    suspend fun deleteNota(notasEntity: NotasEntity)
}