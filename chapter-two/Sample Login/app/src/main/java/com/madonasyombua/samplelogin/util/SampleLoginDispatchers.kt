package com.madonasyombua.samplelogin.util

import kotlinx.coroutines.CoroutineDispatcher

class SampleLoginDispatchers(
    val default: CoroutineDispatcher,
    val main: CoroutineDispatcher,
    val io: CoroutineDispatcher
) {
    companion object {
        fun createTestDispatchers(coroutineDispatcher: CoroutineDispatcher): SampleLoginDispatchers {
            return SampleLoginDispatchers(
                default = coroutineDispatcher,
                main = coroutineDispatcher,
                io = coroutineDispatcher
            )
        }
    }
}