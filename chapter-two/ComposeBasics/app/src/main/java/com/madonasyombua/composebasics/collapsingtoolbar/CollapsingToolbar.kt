package com.madonasyombua.composebasics.collapsingtoolbar

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.madonasyombua.composebasics.R

private val height = 260.dp
private val titleToolbar = 50.dp

@Composable
fun CollapsingToolbarExample() {
    val scrollState: ScrollState = rememberScrollState(0)

    val headerHeight = with(LocalDensity.current) { height.toPx() }
    val toolbarHeight = with(LocalDensity.current) { titleToolbar.toPx() }

    Box(
        modifier = Modifier.fillMaxSize()
    ) {
        CollapsingHeader(scrollState, headerHeight)
        FactsAboutNewYork(scrollState)
        OurToolBar(scrollState, headerHeight, toolbarHeight)
        City()
    }
}

@Composable
private fun CollapsingHeader(scroll: ScrollState, headerHeight: Float) {
    Box(modifier = Modifier
        .fillMaxWidth()
        .height(height)
        .graphicsLayer {
            translationY = -scroll.value.toFloat() / 2f
            alpha = (-1f / headerHeight) * scroll.value + 1
        }
    ) {
        Image(
            painter = painterResource(id = R.drawable.nyc),
            contentDescription = stringResource(id = R.string.new_york),
            contentScale = ContentScale.FillBounds
        )

        Box(
            Modifier
                .fillMaxSize()
                .background(
                    brush = Brush.verticalGradient(
                        colors = listOf(Color.Transparent, Color(0xFF6D38CA)),
                        startY = 1 * headerHeight / 5
                    )
                )
        )
    }
}

@Composable
private fun FactsAboutNewYork(scroll: ScrollState) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier.verticalScroll(scroll)
    ) {
        Spacer(Modifier.height(height))
        repeat(5) {
            Text(
                text = stringResource(R.string.text),
                style = MaterialTheme.typography.body1,
                textAlign = TextAlign.Justify,
                modifier = Modifier
                    .background(Color(0xFFF2F4F7))
                    .padding(16.dp)
            )
        }
    }
}

@Composable
private fun OurToolBar(scroll: ScrollState, headerHeightPx: Float, toolbarHeight: Float) {
    val bottom = headerHeightPx - toolbarHeight
    val showToolbar by remember {
        derivedStateOf {
            scroll.value >= bottom
        }
    }

    AnimatedVisibility(
        visible = showToolbar,
        enter = fadeIn(animationSpec = tween(200)),
        exit = fadeOut(animationSpec = tween(200))
    ) {
        TopAppBar(
            modifier = Modifier.background(
                brush = Brush.horizontalGradient(
                    listOf(Color(R.color.teal_200), Color(R.color.teal_700))
                )
            ),
            title = {},
            backgroundColor = Color.Transparent,
            elevation = 0.dp
        )
    }
}

@Composable
private fun City() {
    Text(
        text = stringResource(id = R.string.new_york),
        fontSize = 20.sp,
        fontWeight = FontWeight.Bold,
        modifier = Modifier.padding(start = 24.dp, top = 16.dp)
    )
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {

    CollapsingToolbarExample()

}
