package com.madonasyombua.guialerts.components


import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.ExtendedFloatingActionButton
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.madonasyombua.guialerts.R

@Composable
fun ActionComponentsExample() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(top = 245.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        FloatingActionButton(onClick = { /* do something */ }) {
            Icon(Icons.Default.Add, contentDescription = stringResource(id = R.string.add))
        }

        Spacer(modifier = Modifier.padding(10.dp))

        ExtendedFloatingActionButton(
            text = { Text(stringResource(id = R.string.add_item)) },
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
@Preview(showBackground = true)
@Composable
fun ShowActionComponentExample(){
    ActionComponentsExample()
}