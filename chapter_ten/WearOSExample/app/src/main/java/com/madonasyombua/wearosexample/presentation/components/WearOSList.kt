package com.madonasyombua.wearosexample.presentation.components

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.wear.compose.material.*


@Composable
fun WearOSList(itemList: List<String>, modifier: Modifier) {
    val scalingListState = rememberScalingLazyListState()
    Scaffold(
        timeText = { TimeText(modifier = Modifier.scrollAway(scalingListState)) },
        vignette = { Vignette(vignettePosition = VignettePosition.TopAndBottom) },
        positionIndicator = {
            PositionIndicator(
                scalingLazyListState = scalingListState
            )
        }
    ) {
        ScalingLazyColumn(
            modifier = Modifier.fillMaxSize(),
            autoCentering = AutoCenteringParams(itemIndex = 0),
            state = scalingListState
        ) {

            items(itemList) { item ->
                WearOSListItem(item = item)
            }
        }
    }
}

@Composable
fun WearOSListItem(item: String) {
    Text(text = item)
}