package com.madonasyombua.pagingjetpackexample.data.service

import com.madonasyombua.pagingjetpackexample.data.NewsArticleResponse
import retrofit2.http.GET
import retrofit2.http.Query

/**
 * TODO 1: Grab your own API from //https://newsapi.org/ and pass
 * "everything?q=apple&sortBy=popularity&apiKey=${YOURAPIKEY}&pageSize=20"
 */
interface NewsApiService {
    @GET("everything?q=apple&sortBy=popularity&apiKey${"YOURAPIKEY"}=&pageSize=20")
    suspend fun getNews(
        @Query("page") page: Int
    ): NewsArticleResponse
}