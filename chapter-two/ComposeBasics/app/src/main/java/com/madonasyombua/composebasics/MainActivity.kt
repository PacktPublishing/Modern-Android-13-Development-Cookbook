package com.madonasyombua.composebasics

import android.os.Build
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.annotation.RequiresApi
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.madonasyombua.composebasics.components.ButtonWithIcon
import com.madonasyombua.composebasics.components.CornerCutShapeButton
import com.madonasyombua.composebasics.components.EditTextExample
import com.madonasyombua.composebasics.components.ElevatedButtonExample
import com.madonasyombua.composebasics.components.ImageViewExample
import com.madonasyombua.composebasics.components.NotOutlinedEditTextExample
import com.madonasyombua.composebasics.components.RoundCornerShapeButton
import com.madonasyombua.composebasics.pagerexample.CityTabCarousel
import com.madonasyombua.composebasics.ui.theme.ComposeBasicsTheme

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposeBasicsTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    Column(
                        modifier = Modifier
                            .fillMaxWidth()
                            .fillMaxSize()
                            .padding(start = 12.dp, end = 12.dp)
                    ) {
                        EditTextExample()
                        NotOutlinedEditTextExample()
                        ButtonWithIcon()
                        CornerCutShapeButton()
                        RoundCornerShapeButton()
                        ElevatedButtonExample()
                        ImageViewExample()

                    }
                }
            }
        }
    }
}
