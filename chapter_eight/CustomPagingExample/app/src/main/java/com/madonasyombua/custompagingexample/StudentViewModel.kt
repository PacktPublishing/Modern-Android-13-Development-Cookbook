package com.madonasyombua.custompagingexample

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.madonasyombua.custompagingexample.data.StudentPaginatorImpl
import com.madonasyombua.custompagingexample.data.StudentRepository
import com.madonasyombua.custompagingexample.uistate.UIState
import kotlinx.coroutines.launch

class StudentViewModel : ViewModel() {
    private val studentRepository = StudentRepository()
    var state by mutableStateOf(UIState())

    private val ourPaginator = StudentPaginatorImpl(
        key = state.page,
        loadUpdated = { state = state.copy(loading = it) },
        request = { studentRepository.getStudents(it, 24) },
        nextKey = { state.page + 1 },
        error = { state = state.copy(error = it?.localizedMessage) },
        success = { student, newKey ->
            state = state.copy(
                studentProfile = state.studentProfile + student,
                page = newKey,
                end = student.isEmpty()
            )
        }
    )

    init {
        loadStudentProfile()
    }

    fun loadStudentProfile() {
        viewModelScope.launch {
            ourPaginator.loadNextStudent()
        }
    }
}