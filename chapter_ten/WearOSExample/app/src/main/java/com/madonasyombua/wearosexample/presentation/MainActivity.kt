/* While this template provides a good starting point for using Wear Compose, you can always
 * take a look at https://github.com/android/wear-os-samples/tree/main/ComposeStarter and
 * https://github.com/android/wear-os-samples/tree/main/ComposeAdvanced to find the most up to date
 * changes to the libraries and their usages.
 */

package com.madonasyombua.wearosexample.presentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.AccountBox
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.wear.compose.material.*
import com.madonasyombua.wearosexample.R
import com.madonasyombua.wearosexample.presentation.components.ChipWearExample
import com.madonasyombua.wearosexample.presentation.components.MessageCard
import com.madonasyombua.wearosexample.presentation.components.ToggleChipWearExample
import com.madonasyombua.wearosexample.presentation.theme.WearOSExampleTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            WearApp()
        }
    }
}

@Composable
fun WearApp() {
    WearOSExampleTheme {
        /* If you have enough items in your list, use [ScalingLazyColumn] which is an optimized
         * version of LazyColumn for wear devices with some added features. For more information,
         * see d.android.com/wear/compose.
         */
        val itemList = listOf(
            "Item 1",
            "Item 2",
            "Item 3",
            "Item 4",
            "Item 5",
            "Item 6",
            "Item 7",
            "Item 8",
            "Item 9",
            "Item 10",
            "Item 11",
            "Item 12",
            "Item 13",
            "Item 14",
            "Item 15"
        )

        val contentModifier = Modifier
            .fillMaxWidth()
            .padding(bottom = 8.dp)
        val iconModifier = Modifier
            .size(24.dp)
            .wrapContentSize(align = Alignment.Center)

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
            //TODO uncomment this to run the WearOSList composable
            //WearOSList(itemList = itemList, modifier = contentModifier)
            ScalingLazyColumn(
                modifier = Modifier.fillMaxSize(),
                autoCentering = AutoCenteringParams(itemIndex = 0),
                state = scalingListState
            ) {
                item { SampleButton(contentModifier) }
                item { SampleButton2(contentModifier, iconModifier) }
                item { MessageCard(contentModifier, iconModifier) }
                item { ChipWearExample(contentModifier, iconModifier) }
                item { ToggleChipWearExample(contentModifier) }
            }
        }
    }
}


@Composable
fun SampleButton(modifier: Modifier) {
    Button(
        onClick = { /* Handle button click */ },
        modifier = modifier
    ) {
        Text("Click me")
    }
}

@Composable
fun SampleButton2(
    modifier: Modifier, iconModifier: Modifier
) {
    Row(
        modifier = modifier,
        horizontalArrangement = Arrangement.Center
    ) {

        Button(
            modifier = Modifier.size(ButtonDefaults.LargeButtonSize),
            onClick = { /* Handle button click */ },
        ) {
            Icon(
                imageVector = Icons.Rounded.AccountBox,
                contentDescription = stringResource(id = R.string.account_box_icon),
                modifier = iconModifier
            )
        }
    }
}

@Preview(device = Devices.WEAR_OS_SMALL_ROUND, showSystemUi = true)
@Composable
fun DefaultPreview() {
    WearApp()
}