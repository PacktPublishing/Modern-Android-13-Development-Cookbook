package com.madonasyombua.samplelogin.login.components

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Visibility
import androidx.compose.material.icons.filled.VisibilityOff
import androidx.compose.runtime.Composable
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.madonasyombua.samplelogin.R
import com.madonasyombua.samplelogin.data.AuthenticationState
import com.madonasyombua.samplelogin.util.TestTags

@Composable
fun UserNameField(
    authState: AuthenticationState,
    onValueChanged: (String) -> Unit,
    isError: Boolean = authState.userName.contains("[^a-zA-z0-9]".toRegex())
) {
    OutlinedTextField(
        value = authState.userName,
        onValueChange = {
            onValueChanged(it)
        },
        enabled = !authState.loading,
        label = { Text(stringResource(id = R.string.enter_name)) },
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 16.dp)
            .testTag(TestTags.LoginContent.USERNAME_FIELD),
        colors = TextFieldDefaults.outlinedTextFieldColors(
            focusedBorderColor = Color.Blue,
            unfocusedBorderColor = Color.Black
        ),
        isError = isError,
        maxLines = 1,
        singleLine = true
    )

    if (authState.userName.contains("[^a-zA-z0-9]".toRegex())) {
        Text(
            text = stringResource(id = R.string.error),
            fontSize = 14.sp,
            modifier = Modifier.padding(horizontal = 30.dp, vertical = 6.dp)
        )
    }
}

@Composable
fun PasswordInputField(
    authState: AuthenticationState,
    onValueChanged: (String) -> Unit,
    passwordToggleVisibility: (Boolean) -> Unit,
    text: String
) {
    OutlinedTextField(
        value = authState.password,
        onValueChange = { onValueChanged(it) },
        label = { Text(text = text) },
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 16.dp)
            .testTag(TestTags.LoginContent.PASSWORD_FIELD),
        enabled = !authState.loading,
        trailingIcon = {
            IconButton(onClick =
            {
                if (!authState.loading) passwordToggleVisibility(!authState.togglePasswordVisibility)
            })
            {
                Icon(
                    imageVector = if (authState.togglePasswordVisibility) Icons.Default.Visibility else Icons.Default.VisibilityOff,
                    contentDescription = stringResource(id = R.string.toggle)
                )
            }
        },
        visualTransformation = if (authState.togglePasswordVisibility) VisualTransformation.None else PasswordVisualTransformation(),
        colors = TextFieldDefaults.outlinedTextFieldColors(
            focusedBorderColor = Color.Blue,
            unfocusedBorderColor = Color.Black
        ),
        maxLines = 1,
        singleLine = true
    )
}


@Composable
fun LoginButton(
    isLoading: Boolean,
    enabled: Boolean = false,
    onLoginClicked: () -> Unit,
    text: String
) {

    Button(
        onClick = onLoginClicked,
        enabled = enabled,
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 24.dp)
            .testTag(TestTags.LoginContent.SIGN_IN_BUTTON),
        shape = RoundedCornerShape(20.dp),
        border = BorderStroke(2.dp, Color.Gray),
        colors = ButtonDefaults.buttonColors(
            contentColor = Color.Blue,
            backgroundColor = Color.White
        )
    ) {
        if (isLoading) {
            AnimatedVisibility(visible = isLoading) {
                Row {
                    CircularProgressIndicator(
                        color = MaterialTheme.colors.onPrimary
                    )
                }
            }
        } else {
            Text(
                text = text,
                fontSize = 14.sp,
                modifier = Modifier.padding(horizontal = 30.dp, vertical = 6.dp)
            )
        }

    }
}