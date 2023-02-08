package com.madonasyombua.roomexample.service

import com.madonasyombua.roomexample.data.UserInfo
import kotlinx.coroutines.flow.Flow

interface UserInfoService {
    fun getUserInformationFromDB(): Flow<UserInfo>
    suspend fun addUserInformationInDB(userInformation: UserInfo)
}