package com.madonasyombua.composebasics.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CutCornerShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.madonasyombua.composebasics.R

@Composable
fun EditTextExample() {
    OutlinedTextField(
        value = "",
        onValueChange = {},
        label = { Text(stringResource(id = R.string.sample)) },
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 16.dp),
        colors = TextFieldDefaults.outlinedTextFieldColors(
            focusedBorderColor = Color.Blue,
            unfocusedBorderColor = Color.Black
        )
    )
}

@Composable
fun NotOutlinedEditTextExample() {
    TextField(
        value = "",
        onValueChange = {},
        label = { Text(stringResource(id = R.string.sample)) },
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 8.dp, bottom = 16.dp),
        colors = TextFieldDefaults.outlinedTextFieldColors(
            focusedBorderColor = Color.Blue,
            unfocusedBorderColor = Color.Black
        )
    )
}

@Composable
fun ButtonWithIcon() {
    Button(onClick = {}) {
        Icon(
            painterResource(id = R.drawable.ic_baseline_shopping_bag_24),
            contentDescription = stringResource(id = R.string.shop),
            modifier = Modifier.size(20.dp)
        )

        Text(text = stringResource(id = R.string.buy), Modifier.padding(start = 10.dp))
    }
}

@Composable
fun CornerCutShapeButton() {
    Button(onClick = {}, shape = CutCornerShape(10)) {
        Text(text = stringResource(id = R.string.cornerButton))
    }
}

@Composable
fun RoundCornerShapeButton() {
    Button(onClick = {}, shape = RoundedCornerShape(10.dp)) {
        Text(text = stringResource(id = R.string.rounded))
    }
}

@Composable
fun ElevatedButtonExample() {
    Button(
        onClick = {},
        elevation = ButtonDefaults.elevation(
            defaultElevation = 10.dp,
            pressedElevation = 15.dp,
            disabledElevation = 0.dp
        )
    ) {
        Text(text = stringResource(id = R.string.elevated))
    }
}

@Composable
fun ImageViewExample() {
    Image(
        painterResource(id = R.drawable.android),
        contentDescription = stringResource(id = R.string.image),
        modifier = Modifier
            .size(200.dp)
    )
}


@Preview(showBackground = true)
@Composable
fun UIElementsPreview() {
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