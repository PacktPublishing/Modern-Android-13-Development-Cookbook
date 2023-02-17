package com.madonasyombua.pagingjetpackexample.data.pager

import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.madonasyombua.pagingjetpackexample.data.NewsArticle
import com.madonasyombua.pagingjetpackexample.data.service.NewsApiService

class NewsArticlePagingSource(
    private val newsApiService: NewsApiService,
) : PagingSource<Int, NewsArticle>() {
    override fun getRefreshKey(state: PagingState<Int, NewsArticle>): Int? {
        return state.anchorPosition?.let { anchorPosition ->
            state.closestPageToPosition(anchorPosition)?.prevKey?.plus(1)
                ?: state.closestPageToPosition(anchorPosition)?.nextKey?.minus(1)
        }
    }

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, NewsArticle> {
        return try {
            val page = params.key ?: 1
            val response = newsApiService.getNews(page = page)

            LoadResult.Page(
                data = response.articles,
                prevKey = if (page == 1) null else page.minus(1),
                nextKey = if (response.articles.isEmpty()) null else page.plus(1),
            )
        } catch (e: Exception) {
            LoadResult.Error(e)
        }
    }
}