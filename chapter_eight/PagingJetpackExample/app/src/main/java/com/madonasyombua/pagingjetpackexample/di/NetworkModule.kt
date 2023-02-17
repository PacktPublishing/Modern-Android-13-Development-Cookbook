package com.madonasyombua.pagingjetpackexample.di

import com.madonasyombua.pagingjetpackexample.data.repository.NewsArticleRepository
import com.madonasyombua.pagingjetpackexample.data.service.NewsApiService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent

@Module
@InstallIn(ViewModelComponent::class)
class HiltModule {
    @Provides
    fun provideNewsRepository(newsApiService: NewsApiService): NewsArticleRepository =
        NewsArticleRepository(newsApiService)
}