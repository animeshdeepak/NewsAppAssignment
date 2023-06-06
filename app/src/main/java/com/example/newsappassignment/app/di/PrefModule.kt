package com.example.newsappassignment.app.di

import android.content.Context
import com.example.newsappassignment.app.di.qualifiers.IODispatcher
import com.example.newsappassignment.data.repoimpl.DataStorePref
import com.example.newsappassignment.domain.repo.IDataStorePref
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import kotlinx.coroutines.CoroutineDispatcher
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
object PrefModule {
    @Singleton
    @Provides
    fun providePreferences(
        @ApplicationContext app: Context,
        @IODispatcher ioDispatcher: CoroutineDispatcher
    ): IDataStorePref = DataStorePref(app, ioDispatcher)
}