package com.madonasyombua.wearosexample.presentation.components

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Email
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.wear.compose.material.AppCard
import androidx.wear.compose.material.Icon
import androidx.wear.compose.material.Text
import com.madonasyombua.wearosexample.R

@Composable
fun MessageCard(modifier: Modifier, iconModifier: Modifier) {
    AppCard(
        modifier = modifier,
        appImage = {
            Icon(
                modifier = iconModifier,
                imageVector = Icons.Rounded.Email,
                contentDescription = stringResource(id = R.string.message_icon)
            )
        },
        onClick = { /*Do something*/ },
        appName = { stringResource(id = R.string.notification_message) },
        time = { stringResource(id = R.string.time) },
        title = { stringResource(id = R.string.notification_owner) }) {
        Text(text = stringResource(id = R.string.hi_android))
    }

}