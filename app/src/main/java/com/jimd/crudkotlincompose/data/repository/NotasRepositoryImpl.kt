package com.jimd.crudkotlincompose.data.repository

import android.util.Log
import com.jimd.crudkotlincompose.data.dao.NotasDao
import com.jimd.crudkotlincompose.data.entities.EtiquetaEntity
import com.jimd.crudkotlincompose.data.mappers.toEntity
import com.jimd.crudkotlincompose.data.mappers.toEntityForInsert
import com.jimd.crudkotlincompose.data.mappers.toModelAll
import com.jimd.crudkotlincompose.data.mappers.toModelForUpdate
import com.jimd.crudkotlincompose.data.repository.model.EtiquetasModelAll
import com.jimd.crudkotlincompose.data.repository.model.EtiquetasModelForInsert
import com.jimd.crudkotlincompose.data.repository.model.EtiquetasModelInsert
import com.jimd.crudkotlincompose.data.repository.model.NotasModel
import com.jimd.crudkotlincompose.data.repository.model.NotasModelAll
import com.jimd.crudkotlincompose.data.repository.model.NotasModelForUpdate
import com.jimd.crudkotlincompose.data.repository.model.NotasModelForUpdateAndDelete
import com.jimd.crudkotlincompose.domain.NotasRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.map
import java.util.Date
import javax.inject.Inject

class NotasRepositoryImpl @Inject constructor(
    private val dao: NotasDao
):NotasRepository {
    override fun getAllEtiquetas(): Flow<List<EtiquetasModelAll>> {
        return try {
            dao.getAllEtiquetas().map { etiquetas->
                etiquetas.map {
                    it.toModelAll()
                }
            }
        }catch (e:Exception){
            flow { emptyList<EtiquetasModelAll>() }
        }
    }

    override suspend fun getEtiqueta(id: Int): EtiquetaEntity {
        return  try {
            dao.getEtiqueta(id)
        }catch (e:Exception){
            EtiquetaEntity(0,"", Date())
        }
    }

    override suspend fun getAllEtiquetasForCont(): Int {
        return dao.getAllEtiquetasForCont()
    }

    override suspend fun insertEtiquetaIfDbIsEmpty(etiquetasModelForInsert: EtiquetasModelForInsert) {
        dao.insertEtiquetaIfDbIsEmpty(etiquetasModelForInsert.toEntity())
    }

    override suspend fun insertEtiqueta(etiquetasModelInsert: EtiquetasModelInsert) {
        dao.insertEtiqueta(etiquetasModelInsert.toEntity())
    }

    override suspend fun insertNota(notasModel: NotasModel) {
        dao.insertNota(notasModel.toEntityForInsert())
    }

    override fun getAllNotas():Flow<List<NotasModelAll>> {
        return try {
            dao.getAllNotas().map {entity->
                entity.map {
                    val etiqueta = getEtiqueta(it.idEtiqueta).detalle
                    Log.i("LOLO","Despues de etiqueta -> $etiqueta")
                    NotasModelAll(
                        it.id, titulo = it.titulo, nota = it.nota, etiqueta = etiqueta, fecha_creada = it.fecha_creada.toString()
                    )
//                    it.toModelAll()
                }
            }
        }catch (e:Exception){
            flow { emptyList<NotasModelAll>() }
        }
    }

    override fun getAllNotasForEtiqueta(id: Int): Flow<List<NotasModelAll>> {
        return try {
            dao.getAllNotasForEtiqueta(id).map { notas->
                notas.map {
                    val etiqueta = getEtiqueta(it.idEtiqueta).detalle
                    NotasModelAll(
                        it.id, titulo = it.titulo, nota = it.nota, etiqueta = etiqueta, fecha_creada = it.fecha_creada.toString()
                    )
//                    it.toModelAll()
                }
            }
        }catch (e:Exception){
            flow { emptyList<NotasModelAll>() }
        }
    }

    override suspend fun notasUpdate(notasModelForUpdate: NotasModelForUpdateAndDelete) {
        dao.notasUpdate(notasModelForUpdate.toEntityForInsert())
    }

    override suspend fun getNotaForId(id: Int): NotasModelForUpdate {
        return dao.getNotaForId(id).toModelForUpdate()
    }

    override suspend fun deleteNota(notasModelForUpdateAndDelete: NotasModelForUpdateAndDelete) {
        dao.deleteNota(notasModelForUpdateAndDelete.toEntityForInsert())
    }

}