package com.jimd.crudkotlincompose.data.repository

import com.jimd.crudkotlincompose.data.dao.NotasDao
import com.jimd.crudkotlincompose.data.entities.NotasEntity
import com.jimd.crudkotlincompose.domain.NotasRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.emitAll
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class NotasRepositoryImpl @Inject constructor(
    private val dao: NotasDao
):NotasRepository {
    override suspend fun insertNota(notasEntity: NotasEntity) {
        dao.insertNota(notasEntity)
    }

    override fun getAllNotas():Flow<List<NotasEntity>> {
        return try {
            dao.getAllNotas()
        }catch (e:Exception){
            flow { emptyList<NotasEntity>() }
        }
    }

    override suspend fun notasUpdate(notasEntity: NotasEntity) {
        dao.notasUpdate(notasEntity)
    }

    override suspend fun getNotaForId(id: Int): NotasEntity {
        return dao.getNotaForId(id)
    }

    override suspend fun deleteNota(notasEntity: NotasEntity) {
        dao.deleteNota(notasEntity)
    }

}