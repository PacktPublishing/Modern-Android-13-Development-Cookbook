package com.madonasyombua.pagingjetpackexample.di

import com.madonasyombua.pagingjetpackexample.constants.Constants.Companion.BASE_URL
import com.madonasyombua.pagingjetpackexample.data.service.NewsApiService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class RetrofitModule{

    @Singleton
    @Provides
    fun provideRetrofitInstance(): NewsApiService = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .build()
        .create(NewsApiService::class.java)
}