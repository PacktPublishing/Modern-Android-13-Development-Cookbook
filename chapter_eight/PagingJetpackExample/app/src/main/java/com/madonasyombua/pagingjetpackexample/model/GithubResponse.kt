package com.madonasyombua.pagingjetpackexample.model

import com.google.gson.annotations.SerializedName

data class GithubResponseItem(
    @SerializedName("avatar_url")
    val avatarUrl: String,
    @SerializedName("id")
    val id: Int,
    @SerializedName("login")
    val login: String
)