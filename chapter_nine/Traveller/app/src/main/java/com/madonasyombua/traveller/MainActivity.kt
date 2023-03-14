package com.madonasyombua.traveller

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.material3.windowsizeclass.ExperimentalMaterial3WindowSizeClassApi
import androidx.compose.material3.windowsizeclass.calculateWindowSizeClass
import androidx.compose.runtime.collectAsState
import androidx.lifecycle.flowWithLifecycle
import androidx.lifecycle.lifecycleScope
import androidx.window.layout.FoldingFeature
import androidx.window.layout.WindowInfoTracker
import com.madonasyombua.traveller.components.CityApp
import com.madonasyombua.traveller.ui.theme.TravellerTheme
import com.madonasyombua.traveller.util.DevicePosture
import com.madonasyombua.traveller.util.cityPosture
import com.madonasyombua.traveller.util.separating
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.stateIn

class MainActivity : ComponentActivity() {
    private val cityViewModel: CityViewModel by viewModels()

    @OptIn(ExperimentalMaterial3WindowSizeClassApi::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val postureStateFlow = WindowInfoTracker.getOrCreate(this).windowLayoutInfo(this)
            .flowWithLifecycle(this.lifecycle)
            .map { layoutInfo ->
                val foldingFeature =
                    layoutInfo.displayFeatures
                        .filterIsInstance<FoldingFeature>()
                        .firstOrNull()
                when {
                    cityPosture(foldingFeature) ->
                        DevicePosture.CityPosture(foldingFeature.bounds)

                    separating(foldingFeature) ->
                        DevicePosture.Separating(foldingFeature.bounds, foldingFeature.orientation)

                    else -> DevicePosture.NormalPosture
                }
            }
            .stateIn(
                scope = lifecycleScope,
                started = SharingStarted.Eagerly,
                initialValue = DevicePosture.NormalPosture
            )

        setContent {
            TravellerTheme {
                // A surface container using the 'background' color from the theme
                val windowSize = calculateWindowSizeClass(activity = this)
                val devicePosture = postureStateFlow.collectAsState().value
                CityApp(
                    windowSizeClass = windowSize.widthSizeClass,
                    devicePosture = devicePosture,
                    cityViewModel = cityViewModel
                )

            }
        }
    }
}
