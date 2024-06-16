package com.jimd.crudkotlincompose.data.repository

import android.content.Context
import androidx.room.Room
import androidx.test.core.app.ApplicationProvider
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.jimd.crudkotlincompose.data.dao.NotasDao
import com.jimd.crudkotlincompose.data.db.NotasDatabase
import com.jimd.crudkotlincompose.data.entities.NotasEntity
import kotlinx.coroutines.runBlocking
import org.junit.After
import org.junit.Assert.*
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import java.util.Date

@RunWith(AndroidJUnit4::class)
class NotasRepositoryImplTest {
private lateinit var dao: NotasDao
private lateinit var db:NotasDatabase
    @Before
    fun createDb() {
        val context = ApplicationProvider.getApplicationContext<Context>()
        db = Room.inMemoryDatabaseBuilder(context,NotasDatabase::class.java).build()
        dao = db.notasDao()
    }

    @After
    fun closeDb() {
        db.close()
    }

    @Test
    @Throws(Exception::class)
    fun insertarNotas()= runBlocking{
        val miNota = NotasEntity(1,"Nota 1","Esta es una nota de text",1, Date())
        dao.insertNota(miNota)
        val notaExtraida = dao.getNotaForId(miNota.id)
        assertEquals(miNota.titulo, notaExtraida.titulo)
    }
}