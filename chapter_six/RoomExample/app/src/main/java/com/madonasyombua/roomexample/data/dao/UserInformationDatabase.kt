package com.madonasyombua.roomexample.data.dao

import androidx.room.Database
import androidx.room.RoomDatabase
import com.madonasyombua.roomexample.data.UserInformationModel

@Database(entities = [UserInformationModel::class], version = 1, exportSchema = false)
abstract class UserInformationDatabase : RoomDatabase() {
    abstract fun userInformationDao(): UserInformationDao
}