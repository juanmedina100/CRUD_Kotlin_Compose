package com.jimd.crudkotlincompose.ui.theme.ui.home

import android.util.Log
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.jimd.crudkotlincompose.data.entities.NotasEntity
import com.jimd.crudkotlincompose.data.repository.model.EtiquetasModelForInsert
import com.jimd.crudkotlincompose.data.repository.model.EtiquetasModelInsert
import com.jimd.crudkotlincompose.data.repository.model.NotasModelForUpdateAndDelete
import com.jimd.crudkotlincompose.domain.NotasRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import java.util.Date
import javax.inject.Inject

@HiltViewModel
class NotasHomeViewModel @Inject constructor(
    private val repo: NotasRepository
):ViewModel(){


    var stateHome by mutableStateOf(StateHome())
    fun onEvent(addEtiquetasEvent: AddEtiquetasEvent){
        when(addEtiquetasEvent){
            is AddEtiquetasEvent.changeEtiqueta -> {
                stateHome = stateHome.copy(
                    newEtiqueta = addEtiquetasEvent.etiqueta
                )
            }
            AddEtiquetasEvent.saveEtiqueta -> {
                insertEtiqueta()
            }
            AddEtiquetasEvent.deleteNota -> {
                deleteNota()
            }
            is AddEtiquetasEvent.notaABorrar -> {
                stateHome = stateHome.copy(
                    idABorrar = addEtiquetasEvent.id
                )
            }
            is AddEtiquetasEvent.etiquetaSeleccionada -> {
                stateHome = stateHome.copy(
                    idEtiqueta = addEtiquetasEvent.idEtiqueta
                )
            }
        }
    }

    fun getAllNotas(){
        viewModelScope.launch(Dispatchers.IO) {
            repo.getAllNotas().collect{
                Log.i("LOLO","ViewModel -> $it")
                stateHome = stateHome.copy(
                    notas = it
                )
                it.map {nota->
                    stateHome = stateHome.copy(
                        id = nota.id,
                        titulo = nota.titulo,
                        nota = nota.nota
                    )
                }
            }
        }
    }
    fun getAllNotasForEtiqueta(id: Int){
        viewModelScope.launch(Dispatchers.IO) {
            repo.getAllNotasForEtiqueta(id).collect{
                stateHome = stateHome.copy(
                    notas = it
                )
                it.map {nota->
                    stateHome = stateHome.copy(
                        id = nota.id,
                        titulo = nota.titulo,
                        nota = nota.nota
                    )
                }
            }
        }
    }



    fun deleteNota(){
        viewModelScope.launch(Dispatchers.IO) {
            repo.deleteNota(
                NotasModelForUpdateAndDelete(
                    id = stateHome.idABorrar,
                    titulo = stateHome.titulo,
                    nota = stateHome.nota,
                    idNota = stateHome.idEtiqueta
                )
            )
        }
    }

    fun getAllEtiquetasForCont(){
        viewModelScope.launch(Dispatchers.IO) {
            val etiquetasEnDb = repo.getAllEtiquetasForCont()
            if(etiquetasEnDb==0){
                insertEtiquetaIfDbIsEmptyOrNewRegister()
            }
        }
    }
    private fun insertEtiquetaIfDbIsEmptyOrNewRegister(){
        viewModelScope.launch(Dispatchers.IO) {
            repo.insertEtiquetaIfDbIsEmpty(
                EtiquetasModelForInsert(
                    id = 0,
                    detalle = "General"
                )
            )
        }
    }

    private fun insertEtiqueta(){
        viewModelScope.launch(Dispatchers.IO) {
            repo.insertEtiqueta(
                EtiquetasModelInsert(
                    etiqueta = stateHome.newEtiqueta
                )
            )
        }
    }

    fun getAllEtiquetas(){
        viewModelScope.launch(Dispatchers.IO) {
            repo.getAllEtiquetas().collect{
                stateHome = stateHome.copy(
                    etiquetas = it
                )
            }
        }
    }
}