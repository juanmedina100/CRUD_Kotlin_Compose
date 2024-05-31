package com.jimd.crudkotlincompose.di

import com.jimd.crudkotlincompose.data.repository.NotasRepositoryImpl
import com.jimd.crudkotlincompose.domain.NotasRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {

    @Singleton
    @Binds
    abstract fun provideRepository(repositoryImpl: NotasRepositoryImpl):NotasRepository
}