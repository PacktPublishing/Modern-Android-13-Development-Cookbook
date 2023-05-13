package com.madonasyombua.custompagingexample.data

import kotlinx.coroutines.delay
class StudentRepository {

    private val ourDataSource = (1..100).map {
        StudentProfile(
            name = "Student $it",
            school = "MIT",
            major = "Computer Science"
        )
    }

    suspend fun getStudents(page: Int, pageSize: Int): Result<List<StudentProfile>> {
        delay(timeMillis = 2000L)
        val start = page * pageSize

        return if (start + pageSize <= ourDataSource.size) {
            Result.success(
                ourDataSource.slice(start until start + pageSize)
            )
        } else Result.success(emptyList())
    }
}