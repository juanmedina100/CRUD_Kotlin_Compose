package com.jimd.crudkotlincompose.domain

import com.jimd.crudkotlincompose.data.entities.EtiquetaEntity
import com.jimd.crudkotlincompose.data.entities.NotasEntity
import com.jimd.crudkotlincompose.data.repository.model.EtiquetasModelAll
import com.jimd.crudkotlincompose.data.repository.model.EtiquetasModelForInsert
import com.jimd.crudkotlincompose.data.repository.model.EtiquetasModelInsert
import com.jimd.crudkotlincompose.data.repository.model.NotasModel
import com.jimd.crudkotlincompose.data.repository.model.NotasModelAll
import com.jimd.crudkotlincompose.data.repository.model.NotasModelForUpdate
import com.jimd.crudkotlincompose.data.repository.model.NotasModelForUpdateAndDelete
import kotlinx.coroutines.flow.Flow

interface NotasRepository {

    //Etiquetas
    fun getAllEtiquetas():Flow<List<EtiquetasModelAll>>

    suspend fun getEtiqueta(id:Int):EtiquetaEntity
    suspend fun getAllEtiquetasForCont():Int
    suspend fun insertEtiquetaIfDbIsEmpty(etiquetasModelForInsert: EtiquetasModelForInsert)
    suspend fun insertEtiqueta(etiquetasModelInsert: EtiquetasModelInsert)



    suspend fun insertNota(notasModel: NotasModel)

    fun getAllNotas():Flow<List<NotasModelAll>>

    fun getAllNotasForEtiqueta(id:Int):Flow<List<NotasModelAll>>
    suspend fun notasUpdate(notasModelForUpdate: NotasModelForUpdateAndDelete)

    suspend fun getNotaForId(id:Int):NotasModelForUpdate

    suspend fun deleteNota(notasModelForUpdateAndDelete: NotasModelForUpdateAndDelete)
}