package com.madonasyombua.roomexample.data

data class UserInfo(
   val id: Int = 0,
    val firstName: String,
    val lastName: String,
    val dateOfBirth: Int,
    val gender: String,
    val city: String,
    val profession: String
)