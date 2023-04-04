package com.madonasyombua.guialerts.components

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.madonasyombua.guialerts.R

@Composable
fun AlertDialogExample() {
    val dialog = remember { mutableStateOf(false) }

    if (dialog.value) {
        AlertDialog(
            onDismissRequest = { dialog.value = false },
            title = {
                Text(
                    text = stringResource(id = R.string.title_message),
                    fontWeight = FontWeight.Bold,
                    color = Color.Black
                )
            },
            text = {
                Text(
                    text = stringResource(id = R.string.body),
                    color = Color.Gray
                )
            },
            confirmButton = {
                Button(
                    onClick = {/*TODO*/ }
                ) {
                    Text(text = stringResource(id = R.string.ok))
                }
            },
            dismissButton = {
                Button(
                    onClick = { dialog.value = false }
                ) {
                    Text(text = stringResource(id = R.string.cancel))
                }
            },
        )
    }

    Button(
        onClick = { dialog.value = true },
        modifier = Modifier.padding(16.dp)
    ) {
        Text(text = stringResource(id = R.string.start))
    }
}

@Preview(showBackground = true)
@Composable
fun ShowAlertDialog(){
    AlertDialogExample()
}