package com.madonasyombua.roomexample.di

import com.madonasyombua.roomexample.service.UserInfoService
import com.madonasyombua.roomexample.service.UserInfoServiceImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
abstract class UserInfoServiceModule {

    @Singleton
    @Binds
    abstract fun bindUserService(userInfoServiceImpl: UserInfoServiceImpl): UserInfoService
}
