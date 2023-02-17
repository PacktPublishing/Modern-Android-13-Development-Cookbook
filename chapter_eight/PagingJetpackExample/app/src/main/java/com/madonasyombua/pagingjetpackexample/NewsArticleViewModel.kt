package com.madonasyombua.pagingjetpackexample

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.PagingData
import androidx.paging.cachedIn
import com.madonasyombua.pagingjetpackexample.data.NewsArticle
import com.madonasyombua.pagingjetpackexample.data.repository.NewsArticleRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

@HiltViewModel
class NewsArticleViewModel @Inject constructor(
    private val repository: NewsArticleRepository,
) : ViewModel() {

    fun getNewsArticle(): Flow<PagingData<NewsArticle>> =
        repository.getNewsArticle().cachedIn(viewModelScope)
}