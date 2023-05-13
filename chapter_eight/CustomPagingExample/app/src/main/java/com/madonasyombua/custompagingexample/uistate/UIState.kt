package com.madonasyombua.custompagingexample.uistate

import com.madonasyombua.custompagingexample.data.StudentProfile

data class UIState(
    val page: Int = 0,
    val loading: Boolean = false,
    val studentProfile: List<StudentProfile> = emptyList(),
    val error: String? = null,
    val end: Boolean = false,
)