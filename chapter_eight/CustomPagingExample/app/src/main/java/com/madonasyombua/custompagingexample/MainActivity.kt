package com.madonasyombua.custompagingexample

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.madonasyombua.custompagingexample.components.StudentProfileCard
import com.madonasyombua.custompagingexample.ui.theme.CustomPagingExampleTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            CustomPagingExampleTheme {
                val viewModel = viewModel<StudentViewModel>()
                val state = viewModel.state
                LazyColumn(
                    modifier = Modifier.fillMaxSize()
                ) {
                    items(state.studentProfile.size) { profile ->
                        val students = state.studentProfile[profile]
                        if (profile >= state.studentProfile.size - 1 && !state.end && !state.loading) {
                            viewModel.loadStudentProfile()
                        }
                        Column(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(2.dp)
                        ) {
                            StudentProfileCard(
                                name = students.name,
                                field = students.major,
                                school = students.school
                            )
                        }

                    }
                    item {
                        if (state.loading) {
                            Row(
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .padding(8.dp),
                                horizontalArrangement = Arrangement.Center
                            ) {
                                CircularProgressIndicator()
                            }
                        }
                    }

                }
            }
        }
    }
}
