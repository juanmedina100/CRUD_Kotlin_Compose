package com.jimd.crudkotlincompose.data.mappers

import com.jimd.crudkotlincompose.data.entities.EtiquetaEntity
import com.jimd.crudkotlincompose.data.entities.NotasEntity
import com.jimd.crudkotlincompose.data.repository.model.EtiquetasModelAll
import com.jimd.crudkotlincompose.data.repository.model.EtiquetasModelForInsert
import com.jimd.crudkotlincompose.data.repository.model.EtiquetasModelInsert
import com.jimd.crudkotlincompose.data.repository.model.NotasModel
import com.jimd.crudkotlincompose.data.repository.model.NotasModelAll
import com.jimd.crudkotlincompose.data.repository.model.NotasModelForUpdate
import com.jimd.crudkotlincompose.data.repository.model.NotasModelForUpdateAndDelete
import java.util.Date

fun NotasModel.toEntityForInsert():NotasEntity{
    return NotasEntity(
        titulo = this.titulo,
        nota = this.nota,
        id = 0,
        fecha_creada = Date(),
        idEtiqueta = this.idNota
    )
}
fun NotasModelForUpdateAndDelete.toEntityForInsert():NotasEntity{
    return NotasEntity(
        id = this.id,
        titulo = this.titulo,
        nota = this.nota,
        fecha_creada = Date(),
        idEtiqueta = this.idNota
    )
}
fun NotasEntity.toModelForUpdate():NotasModelForUpdate{
    return NotasModelForUpdate(
        id = this.id,
        titulo = this.titulo,
        nota = this.nota,
        idEtiqueta = this.idEtiqueta
    )
}
fun NotasEntity.toModelAll():NotasModelAll{
    return NotasModelAll(
        id = this.id,
        titulo = this.titulo,
        nota = this.nota
    )
}
fun EtiquetasModelForInsert.toEntity():EtiquetaEntity{
    return EtiquetaEntity(
        id = this.id,
        detalle = this.detalle,
        fecha_creada = Date()
    )
}
fun EtiquetasModelInsert.toEntity():EtiquetaEntity{
    return EtiquetaEntity(
        id = 0,
        detalle = this.etiqueta,
        fecha_creada = Date()
    )
}
fun EtiquetaEntity.toModelAll():EtiquetasModelAll{
    return EtiquetasModelAll(
        id = this.id,
        detalle = this.detalle
    )
}