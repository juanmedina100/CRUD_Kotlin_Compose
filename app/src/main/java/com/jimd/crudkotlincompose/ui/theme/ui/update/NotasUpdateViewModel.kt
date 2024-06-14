package com.jimd.crudkotlincompose.ui.theme.ui.update

import android.util.Log
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.jimd.crudkotlincompose.data.repository.model.NotasModelForUpdateAndDelete
import com.jimd.crudkotlincompose.domain.NotasRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class NotasUpdateViewModel @Inject constructor(
    private val repo:NotasRepository
) :ViewModel(){


    var stateUpdate by mutableStateOf(NotaUpdateState())
    fun onEvent(notasUpdateEvent: NotasUpdateEvent){
        when(notasUpdateEvent){
            is NotasUpdateEvent.onChangeTitulo -> {
                stateUpdate = stateUpdate.copy(
                    titulo = notasUpdateEvent.titulo
                )
            }
            NotasUpdateEvent.update -> { notasUpdate() }
            is NotasUpdateEvent.onChangeNota -> {
                stateUpdate = stateUpdate.copy(
                    nota = notasUpdateEvent.nota
                )
            }

            is NotasUpdateEvent.onChangeId -> {
                stateUpdate = stateUpdate.copy(
                    id = notasUpdateEvent.id
                )
            }
            is NotasUpdateEvent.onIdEtiqueta -> {
                stateUpdate = stateUpdate.copy(
                    idEtiqueta = notasUpdateEvent.idEtiqueta
                )
            }
        }
    }
    fun notasUpdate(){
        viewModelScope.launch(Dispatchers.IO) {
            repo.notasUpdate(
                NotasModelForUpdateAndDelete(
                    id = stateUpdate.id,
                    titulo = stateUpdate.titulo,
                    nota = stateUpdate.nota,
                    idNota = stateUpdate.idEtiqueta
                )
            )
        }
    }
    fun getNotaForId(id:Int){
        viewModelScope.launch(Dispatchers.IO) {
            val nota = repo.getNotaForId(id)
            stateUpdate = stateUpdate.copy(
                titulo = nota.titulo,
                nota = nota.nota,
                idEtiqueta = nota.idEtiqueta
            )
        }
    }
}