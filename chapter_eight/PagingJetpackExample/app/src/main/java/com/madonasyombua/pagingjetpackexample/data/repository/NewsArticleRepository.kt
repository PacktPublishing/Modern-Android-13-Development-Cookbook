package com.madonasyombua.pagingjetpackexample.data.repository

import androidx.paging.Pager
import androidx.paging.PagingConfig
import com.madonasyombua.pagingjetpackexample.data.pager.NewsArticlePagingSource
import com.madonasyombua.pagingjetpackexample.data.service.NewsApiService
import javax.inject.Inject

class NewsArticleRepository @Inject constructor(
    private val newsApiService: NewsApiService
) {
    fun getNewsArticle() = Pager(
        config = PagingConfig(
            pageSize = 20,
        ),
        pagingSourceFactory = {
            NewsArticlePagingSource(newsApiService)
        }
    ).flow
}