package com.madonasyombua.custompagingexample.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.madonasyombua.custompagingexample.R

@Composable
fun StudentProfileCard(
    name: String,
    field: String,
    school: String
) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 10.dp, start = 12.dp, bottom = 2.dp, end = 12.dp)
            .size(150.dp)
            .clickable {},
        elevation = 10.dp,
        shape = RoundedCornerShape(corner = CornerSize(8.dp))
    ) {
        Row(
            modifier = Modifier.padding(8.dp),
            horizontalArrangement = Arrangement.spacedBy(8.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Image(
                modifier = Modifier
                    .padding(start = 16.dp)
                    .size(60.dp)
                    .clip(CircleShape),
                painter = painterResource(id = R.drawable.avator),
                contentScale = ContentScale.Crop,
                contentDescription = "profile"
            )

            Column(
                modifier = Modifier.padding(start = 12.dp),
                verticalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                Text(
                    text = name,
                    color = Color.Black
                )

                Text(
                    text = field,
                    color = Color.Black
                )
                Text(
                    text = school,
                    color = Color.Black
                )
            }

        }

    }
}
