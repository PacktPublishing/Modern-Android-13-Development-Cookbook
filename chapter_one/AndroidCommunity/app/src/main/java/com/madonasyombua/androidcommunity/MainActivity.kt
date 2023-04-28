package com.madonasyombua.androidcommunity

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.madonasyombua.androidcommunity.ui.theme.AndroidCommunityTheme

/**
 * @author Madona S. Wambua
 */
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AndroidCommunityTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Column(
                        modifier = Modifier
                            .fillMaxSize()
                            .wrapContentSize(Alignment.Center),
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        Greeting("Hello, Android Community")

                        SampleButton()
                    }
                }
            }
        }
    }
}

@Composable
fun SampleButton() {
    Button(
        onClick = { /*Do nothing*/ },
        modifier = Modifier
            .fillMaxWidth()
            .padding(24.dp),
        shape = RoundedCornerShape(20.dp),
        border = BorderStroke(2.dp, Color.Blue),
        colors = ButtonDefaults.buttonColors(
            contentColor = Color.Gray,
            containerColor = Color.White
        )
    ) {
        Text(
            text = stringResource(id = R.string.click_me),
            fontSize = 14.sp,
            modifier = Modifier.padding(horizontal = 30.dp, vertical = 6.dp)
        )

    }
}

@Composable
fun Greeting(name: String) {
    Text(
        text = name
    )
}

/**
 * A preview to help us view the components
 */
@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    AndroidCommunityTheme {
        Greeting("Hello, Android Community")
    }
}