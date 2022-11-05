package com.madonasyombua.samplelogin.util

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.distinctUntilChanged
import kotlinx.coroutines.flow.map
import java.util.concurrent.atomic.AtomicInteger

/**
 * Progress Loader inspired by Chris Banes Tivi idea
 * Credits: https://github.com/chrisbanes/tivi/
 */
class ProgressLoader {
    private val count = AtomicInteger()
    private val loadingState = MutableStateFlow(count.get())

    val flow: Flow<Boolean>
        get() = loadingState.map { it > 0 }.distinctUntilChanged()

    val isLoading get() = count.get() > 0

    fun start() {
        loadingState.value = count.incrementAndGet()
    }

    fun stop() {
        loadingState.value = count.decrementAndGet()
    }
}