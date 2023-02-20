package com.madonasyombua.samplelogin.data

data class AuthenticationState(
    val userName: String = "",
    val password: String = "",
    var togglePasswordVisibility: Boolean = true,
    val loading: Boolean = false,
) {
    fun isValidForm(): Boolean {
        return userName.isNotEmpty() && password.isNotEmpty()
    }

    companion object {
        val EMPTY_STATE = AuthenticationState()
    }
}