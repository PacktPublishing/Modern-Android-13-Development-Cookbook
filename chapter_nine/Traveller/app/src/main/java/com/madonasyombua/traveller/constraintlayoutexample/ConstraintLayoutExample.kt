package com.madonasyombua.traveller.constraintlayoutexample

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.constraintlayout.compose.Dimension
import com.madonasyombua.traveller.R
import com.madonasyombua.traveller.ui.theme.TravellerTheme

@Composable
fun AndroidCommunity() {
    ConstraintLayout {
        val (title, aboutCommunity, androidImage) = createRefs()
        Text(
            text = stringResource(id = R.string.android_community),
            modifier = Modifier
                .constrainAs(title) {
                    top.linkTo(parent.top)
                    start.linkTo(parent.start)
                    end.linkTo(parent.end)
                }
                .padding(top = 12.dp),
            style = TextStyle(
                color = Color.Blue,
                fontSize = 24.sp
            )
        )

        Text(
            text = stringResource(id = R.string.about_community),
            modifier = Modifier
                .constrainAs(aboutCommunity) {
                    top.linkTo(title.bottom)
                    start.linkTo(parent.start)
                    end.linkTo(parent.end)
                    width = Dimension.fillToConstraints
                }
                .padding(top = 12.dp, start = 12.dp, end = 12.dp),
            style = TextStyle(
                fontSize = 18.sp
            )
        )


        Image(
            painter = painterResource(id = R.drawable.android),
            contentDescription = stringResource(id = R.string.android_image),
            modifier = Modifier.constrainAs(androidImage) {
                top.linkTo(aboutCommunity.bottom, margin = 16.dp)
                centerHorizontallyTo(parent)
            }
        )
    }
}

@Preview(showBackground = true)
@Composable
fun ShowAndroidCommunity() {
    TravellerTheme() {
        AndroidCommunity()
    }
}