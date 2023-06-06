package com.example.newsappassignment.app.di

import com.example.newsappassignment.app.di.qualifiers.DefaultDispatcher
import com.example.newsappassignment.app.di.qualifiers.IODispatcher
import com.example.newsappassignment.app.di.qualifiers.MainDispatcher
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers

@Module
@InstallIn(SingletonComponent::class)
object CoroutineModule {

    @MainDispatcher
    @Provides
    fun getMainDispatcher(): CoroutineDispatcher = Dispatchers.Main

    @IODispatcher
    @Provides
    fun getIODispatcher(): CoroutineDispatcher = Dispatchers.IO

    @DefaultDispatcher
    @Provides
    fun getDefaultDispatcher(): CoroutineDispatcher = Dispatchers.Default

}