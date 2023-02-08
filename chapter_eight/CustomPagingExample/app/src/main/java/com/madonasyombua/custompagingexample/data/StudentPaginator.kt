package com.madonasyombua.custompagingexample.data

interface StudentPaginator<Key, Student> {
    suspend fun loadNextStudent()
    fun reset()
}