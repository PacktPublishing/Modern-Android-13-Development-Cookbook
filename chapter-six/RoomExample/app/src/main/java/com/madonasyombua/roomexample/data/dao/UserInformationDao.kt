package com.madonasyombua.roomexample.data.dao

import androidx.room.*
import com.madonasyombua.roomexample.data.UserInformationModel
import kotlinx.coroutines.flow.Flow

@Dao
interface UserInformationDao {

    @Query("SELECT * FROM user_information")
    fun getUsersInformation(): Flow<List<UserInformationModel>>

    @Query("SELECT * FROM user_information WHERE id = :userId")
    fun loadAllUserInformation(userId: Int = 0): Flow<UserInformationModel>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertUserInformation(userInformation: UserInformationModel)

    @Update(onConflict = OnConflictStrategy.REPLACE)
    suspend fun updateUserInformation(userInformation: UserInformationModel)

    @Delete
    suspend fun deleteUserInformation(userInformation: UserInformationModel)
}