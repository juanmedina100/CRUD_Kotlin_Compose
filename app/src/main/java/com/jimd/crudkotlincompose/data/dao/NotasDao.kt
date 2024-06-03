package com.jimd.crudkotlincompose.data.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.jimd.crudkotlincompose.data.entities.EtiquetaEntity
import com.jimd.crudkotlincompose.data.entities.NotasEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface NotasDao {
    //Etiquetas
    @Query("select * from etiquetaentity order by id")
    fun getAllEtiquetas():Flow<List<EtiquetaEntity>>

    @Query("select count(*) from etiquetaentity")
    suspend fun getAllEtiquetasForCont():Int
    @Insert
    suspend fun insertEtiquetaIfDbIsEmpty(etiquetaEntity: EtiquetaEntity)






    @Insert
    suspend fun insertNota(notasEntity: NotasEntity)

    @Query("select * from NotasEntity")
    fun getAllNotas(): Flow<List<NotasEntity>>

    @Query("select * from notasentity where id=:id order by id")
    fun getAllNotasForEtiqueta(id:Int):Flow<List<NotasEntity>>

    @Update
    suspend fun notasUpdate(notasEntity: NotasEntity)
    @Query("select * from NotasEntity where id=:id")
    suspend fun getNotaForId(id:Int):NotasEntity
    @Delete
    suspend fun deleteNota(notasEntity: NotasEntity)
}