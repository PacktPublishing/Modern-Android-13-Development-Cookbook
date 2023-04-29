package com.madonasyombua.roomexample.data

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "user_information")
data class UserInformationModel(
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,
    val firstName: String,
    val lastName: String,
    val dateOfBirth: Int,
    val gender: String,
    val city: String,
    val profession: String
)