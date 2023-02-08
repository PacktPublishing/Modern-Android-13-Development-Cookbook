package com.madonasyombua.roomexample.di

import android.content.Context
import androidx.room.Room
import com.madonasyombua.roomexample.data.dao.UserInformationDao
import com.madonasyombua.roomexample.data.dao.UserInformationDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class DataBaseModule {

    @Singleton
    @Provides
    fun provideDatabase(@ApplicationContext context: Context): UserInformationDatabase {
        return Room
            .databaseBuilder(context, UserInformationDatabase::class.java, "user_information.db")
            .build()
    }

    @Singleton
    @Provides
    fun provideUserInformationDao(userInformationDatabase: UserInformationDatabase): UserInformationDao {
        return userInformationDatabase.userInformationDao()
    }
}