package com.madonasyombua.pagingjetpackexample.data

data class NewsArticleResponse(
    val articles: List<NewsArticle>,
    val status: String,
    val totalResults: Int
)