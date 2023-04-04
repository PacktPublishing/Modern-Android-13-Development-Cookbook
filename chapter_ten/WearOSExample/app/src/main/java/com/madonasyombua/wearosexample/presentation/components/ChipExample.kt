package com.madonasyombua.wearosexample.presentation.components

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Phone
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextOverflow
import androidx.wear.compose.material.Chip
import androidx.wear.compose.material.Icon
import androidx.wear.compose.material.Text
import com.madonasyombua.wearosexample.R

@Composable
fun ChipWearExample(modifier: Modifier, iconModifier: Modifier) {
    Chip(
        modifier = modifier,
        onClick = { /*TODO */ },
        label = {
            Text(
                text = stringResource(id = R.string.chip_detail),
                maxLines = 1,
                overflow = TextOverflow.Ellipsis
            )
        },
        icon = {
            Icon(
                imageVector = Icons.Rounded.Phone,
                contentDescription = stringResource(id = R.string.phone),
                modifier = iconModifier
            )
        },
    )
}