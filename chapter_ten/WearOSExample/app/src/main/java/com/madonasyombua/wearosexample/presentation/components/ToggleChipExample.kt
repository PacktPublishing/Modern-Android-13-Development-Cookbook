package com.madonasyombua.wearosexample.presentation.components

import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextOverflow
import androidx.wear.compose.material.Switch
import androidx.wear.compose.material.Text
import androidx.wear.compose.material.ToggleChip
import com.madonasyombua.wearosexample.R

@Composable
fun ToggleChipWearExample(modifier: Modifier) {
    var isChecked by remember { mutableStateOf(true) }

    ToggleChip(
        modifier = modifier,
        checked = isChecked,
        toggleControl = {
            Switch(
                checked = isChecked
            )
        },
        onCheckedChange = {
            isChecked = it
        },
        label = {
            Text(
                text = stringResource(id = R.string.alert),
                maxLines = 1,
                overflow = TextOverflow.Ellipsis
            )
        }
    )
}