package com.jimd.crudkotlincompose.di

import android.content.Context
import androidx.room.Room
import com.jimd.crudkotlincompose.data.db.NotasDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object NotasModule {

    @Singleton
    @Provides
    fun provideDB(@ApplicationContext context: Context)= Room.databaseBuilder(
        context,NotasDatabase::class.java,"myNotas"
    ).build()

    @Singleton
    @Provides
    fun provideDao(db:NotasDatabase)=db.notasDao()
}