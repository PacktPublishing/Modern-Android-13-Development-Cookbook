package com.madonasyombua.composebasics.pagerexample

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.background
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.selection.selectable
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.ScrollableTabRow
import androidx.compose.material.TabRowDefaults
import androidx.compose.material.Text
import androidx.compose.material.ripple.rememberRipple
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.semantics.Role
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.pager.HorizontalPager
import com.google.accompanist.pager.pagerTabIndicatorOffset
import com.google.accompanist.pager.rememberPagerState
import com.madonasyombua.composebasics.R
import kotlinx.coroutines.launch

@RequiresApi(Build.VERSION_CODES.M)
@OptIn(ExperimentalPagerApi::class)
@Composable
fun CityTabCarousel(
    pages: MutableList<String> = arrayListOf(
        "Spain",
        "New York",
        "Tokyo",
        "Switzerland",
        "Singapore",
        "Paris"
    )
) {
    val context = LocalContext.current
    val pagerState = rememberPagerState()
    val coroutineScope = rememberCoroutineScope()

    Column {
        ScrollableTabRow(
            selectedTabIndex = pagerState.currentPage,
            indicator = { tabPositions ->
                TabRowDefaults.Indicator(
                    Modifier
                        .pagerTabIndicatorOffset(pagerState, tabPositions)
                        .fillMaxHeight(0f)
                )
            },
            edgePadding = 0.dp,
            backgroundColor = Color(context.resources.getColor(R.color.white, null)),
        ) {
            pages.forEachIndexed { index, title ->
                val isSelected = pagerState.currentPage == index

                TabHeader(
                    title,
                    isSelected,
                    onClick = { coroutineScope.launch { pagerState.animateScrollToPage(index) } },
                )
            }
        }

        HorizontalPager(
            count = pages.size,
            state = pagerState,
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight()
                .background(Color.White)

        ) { page ->
            Text(
                text = "Display City Name: ${pages[page]}",
                modifier = Modifier.fillMaxWidth(),
                style = TextStyle(
                    textAlign = TextAlign.Center
                )
            )
        }
    }
}

@RequiresApi(Build.VERSION_CODES.M)
@Composable
private fun TabHeader(
    title: String,
    isSelected: Boolean,
    onClick: () -> Unit
) {
    val context = LocalContext.current
    val color = if (isSelected) R.color.purple_700 else R.color.white
    val ripple =
        rememberRipple(bounded = true, color = Color(context.resources.getColor(color, null)))
    val interactionSource: MutableInteractionSource = remember { MutableInteractionSource() }

    Box(
        modifier = Modifier
            .selectable(
                selected = isSelected,
                onClick = { onClick() },
                enabled = true,
                role = Role.Tab,
                interactionSource = interactionSource,
                indication = ripple
            )
            .padding(top = 10.dp, bottom = 10.dp)
    ) {
        TabCarousel(title = title, isSelected = isSelected)
    }
}

@RequiresApi(Build.VERSION_CODES.M)
@Composable
private fun TabCarousel(title: String, isSelected: Boolean) {
    val context = LocalContext.current
    val color = if (isSelected) R.color.purple_700 else R.color.white
    val textColor = if (isSelected) R.color.white else R.color.black
    Row(
        modifier = Modifier
            .background(
                color = Color(context.resources.getColor(color, null)),
                shape = RoundedCornerShape(25.dp)
            )
            .padding(start = 10.dp, top = 10.dp, end = 10.dp, bottom = 10.dp)
            .width(if (title.length < 11) 70.dp else 110.dp),
        horizontalArrangement = Arrangement.SpaceEvenly
    ) {

        Text(
            text = title,
            color = Color(context.resources.getColor(textColor, null)),
            modifier = Modifier.fillMaxWidth(),
            textAlign = TextAlign.Center
        )
    }
}

@RequiresApi(Build.VERSION_CODES.M)
@Preview(showBackground = true)
@Composable
fun PreviewDegreePlanCarousel() {
    CityTabCarousel()
}
