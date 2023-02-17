@file:Suppress("DEPRECATION")

package com.madonasyombua.pagingjetpackexample.data

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.paging.PagingSource
import com.madonasyombua.pagingjetpackexample.data.pager.NewsArticlePagingSource
import com.madonasyombua.pagingjetpackexample.data.service.NewsApiService
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.TestCoroutineDispatcher
import kotlinx.coroutines.test.runBlockingTest
import kotlinx.coroutines.test.setMain
import okhttp3.MediaType.Companion.toMediaTypeOrNull
import okhttp3.ResponseBody
import okhttp3.ResponseBody.Companion.toResponseBody
import org.junit.After
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.junit.MockitoJUnitRunner
import retrofit2.HttpException
import retrofit2.Response

@ExperimentalCoroutinesApi
@RunWith(MockitoJUnitRunner::class)
class NewsArticlePagingSourceTest {
    @get:Rule
    val instantExecutorRule = InstantTaskExecutorRule()

    @ExperimentalCoroutinesApi
    private val testDispatcher = TestCoroutineDispatcher()

    @Mock
    private lateinit var newsApiService: NewsApiService

    lateinit var newsPagingSource: NewsArticlePagingSource

    @Before
    fun setup() {
        Dispatchers.setMain(testDispatcher)
        newsPagingSource = NewsArticlePagingSource(newsApiService)
    }


    @Test
    fun `news article paging source load failure http error`() = runBlockingTest {
        //setup
        val error = HttpException(
            Response.error<ResponseBody>(
                403, "some content".toResponseBody("plain/text".toMediaTypeOrNull())
            )
        )
        Mockito.doThrow(error)
            .`when`(newsApiService)
            .getNews(
                1
            )

        //trigger
        val expectedResult = PagingSource.LoadResult.Error<Int, NewsArticle>(error)

        //assert
        assertEquals(
            expectedResult, newsPagingSource.load(
                PagingSource.LoadParams.Refresh(
                    key = null,
                    loadSize = 1,
                    placeholdersEnabled = false
                )
            )
        )
    }

    @After
    fun tearDown() {
        testDispatcher.cleanupTestCoroutines()
    }

}