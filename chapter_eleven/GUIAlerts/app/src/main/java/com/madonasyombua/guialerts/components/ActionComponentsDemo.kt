package com.madonasyombua.guialerts.components


import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.ExtendedFloatingActionButton
import androidx.compose.material.FloatingActionButton
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.madonasyombua.guialerts.R

@Composable
fun ActionComponentsExample() {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 245.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        FloatingActionButton(onClick = { /* do something */ }) {
            Icon(Icons.Default.Add, contentDescription = stringResource(id = R.string.add))
        }

        Spacer(modifier = Modifier.padding(10.dp))

        ExtendedFloatingActionButton(
            text = { Text("Add item") },
            onClick = { /* do something */ },
            icon = {
                Icon(
                    Icons.Default.Add,
                    contentDescription = stringResource(id = R.string.add)
                )
            }
        )


    }

}
