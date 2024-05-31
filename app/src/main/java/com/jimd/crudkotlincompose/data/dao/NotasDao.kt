package com.jimd.crudkotlincompose.data.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.jimd.crudkotlincompose.data.entities.NotasEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface NotasDao {

    @Insert
    suspend fun insertNota(notasEntity: NotasEntity)

    @Query("select * from NotasEntity")
    fun getAllNotas(): Flow<List<NotasEntity>>

    @Update
    suspend fun notasUpdate(notasEntity: NotasEntity)
    @Query("select * from NotasEntity where id=:id")
    suspend fun getNotaForId(id:Int):NotasEntity
    @Delete
    suspend fun deleteNota(notasEntity: NotasEntity)
}