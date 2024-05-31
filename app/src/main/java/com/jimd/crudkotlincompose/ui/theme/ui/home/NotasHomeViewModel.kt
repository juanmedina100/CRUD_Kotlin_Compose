package com.jimd.crudkotlincompose.ui.theme.ui.home

import android.util.Log
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.jimd.crudkotlincompose.data.entities.NotasEntity
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


    fun getAllNotas(){
        Log.i("LOLO","ViewModel->init")
        viewModelScope.launch(Dispatchers.IO) {
            repo.getAllNotas().collect{
                Log.i("LOLO","ViewModel->$it")
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
                NotasEntity(
                    id = stateHome.id,
                    titulo = stateHome.titulo,
                    nota = stateHome.nota,
                    fecha_creada = Date()
                )
            )
        }
    }
}