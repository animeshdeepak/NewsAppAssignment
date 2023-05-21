package com.example.newsappassignment.app.di

import android.app.Application
import com.example.newsappassignment.data.remote.NewsApi
import com.example.newsappassignment.data.repoimpl.NewsRepoImpl
import com.example.newsappassignment.domain.repo.INewsRepo
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RepoModule {

    @Provides
    @Singleton
    fun provideNewsRepo(newsApi: NewsApi, appContext: Application): INewsRepo =
        NewsRepoImpl(newsApi, appContext)
}