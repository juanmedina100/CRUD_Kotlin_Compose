package com.jimd.crudkotlincompose.ui.theme.ui.add

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.jimd.crudkotlincompose.data.entities.NotasEntity
import com.jimd.crudkotlincompose.data.repository.model.NotasModel
import com.jimd.crudkotlincompose.domain.NotasRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import java.util.Date
import javax.inject.Inject

@HiltViewModel
class NotasViewModel @Inject constructor(
    private val repo:NotasRepository
) :ViewModel(){


    var stateAdd by mutableStateOf(NotaState())
    fun onEvent(notasEvent: NotasEvent){
        when(notasEvent){
            is NotasEvent.onChangeTitulo -> {
                stateAdd = stateAdd.copy(
                    titulo = notasEvent.titulo,
                    estado = if (notasEvent.titulo.length > 1) true else false
                )
            }
            NotasEvent.save -> { insertNota() }
            is NotasEvent.onChangeNota -> {
                stateAdd = stateAdd.copy(
                    nota = notasEvent.nota
                )
            }
        }
    }

    fun insertNota(){
        viewModelScope.launch(Dispatchers.IO) {
            repo.insertNota(
                NotasModel(
                    titulo = stateAdd.titulo,
                    nota = stateAdd.nota,
                    idNota = stateAdd.idNota
                )
            )
        }
    }
}