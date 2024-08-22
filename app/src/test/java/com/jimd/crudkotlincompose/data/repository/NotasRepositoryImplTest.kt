package com.jimd.crudkotlincompose.data.repository

import androidx.room.Room
import androidx.test.platform.app.InstrumentationRegistry
import com.jimd.crudkotlincompose.data.dao.NotasDao
import com.jimd.crudkotlincompose.data.db.NotasDatabase
import com.jimd.crudkotlincompose.data.repository.model.NotasModelAll
import kotlinx.coroutines.flow.toList
import kotlinx.coroutines.runBlocking
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Test
import org.testng.Assert


//@RunWith(AndroidJUnit4::class)
class NotasRepositoryImplTest {

//    private lateinit var db:NotasDatabase
//    private lateinit var dao:NotasDao
//    private lateinit var repositoryImpl: NotasRepositoryImpl
//
//    @Before
//    fun onBefore() {
//        val context = InstrumentationRegistry.getInstrumentation().context
////        val context = androidx.test.InstrumentationRegistry.getInstrumentation().context
//        db = Room.inMemoryDatabaseBuilder(context, NotasDatabase::class.java).build()
//        dao = db.notasDao()
//        repositoryImpl = NotasRepositoryImpl(dao)
//    }
//    @Test
//    fun calculandoMultiplicacion(){
//        val a = 7
//        val b = 25
//        assertEquals(175,funciones(a,b))
//        Assert.assertEquals(175,funciones(a,b))
//    }
//
//    @Test
//    fun `Carga`() = runBlocking {
//        val notas =repositoryImpl.getAllNotas().toList().size
//        assertEquals(notas,0)
//    }
//
//}
//fun funciones(a:Int,b:Int):Int{
//    return a * b
}

//val notasList = listOf(listOf<NotasModelAll>(
//    NotasModelAll(1,"Nota 1","nota","1", fecha_creada = ""),
//    NotasModelAll(2,"Nota 2","nota","1", fecha_creada = ""),
////    NotasModelAll(3,"Nota 2","nota","1", fecha_creada = ""),
//))