package com.madonasyombua.traveller.components

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.madonasyombua.traveller.R

@Composable
fun ProfileScreen() {
    Text(
        text = stringResource(id = R.string.traveller),
        modifier = Modifier
            .fillMaxSize()
            .padding(32.dp),
        fontSize = 21.sp,
        fontWeight = FontWeight.Medium,
        textAlign = TextAlign.Start
    )
}