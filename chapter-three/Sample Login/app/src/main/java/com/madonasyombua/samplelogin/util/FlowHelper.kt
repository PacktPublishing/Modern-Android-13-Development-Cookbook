package com.madonasyombua.samplelogin.util

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.flow.*

fun <T1, T2, T3, T4, R> combineFlows(
    flow: Flow<T1>,
    flow2: Flow<T2>,
    flow3: Flow<T3>,
    flow4: Flow<T4>,
    transform: suspend (T1, T2, T3, T4) -> R
): Flow<R> = combine(flow, flow2, flow3, flow4) { args: Array<*> ->
    transform(
        args[0] as T1,
        args[1] as T2,
        args[2] as T3,
        args[3] as T4,
    )
}

fun <T> Flow<T>.stateIn(
    coroutineScope: CoroutineScope,
    initialValue: T
): StateFlow<T> = stateIn(
    scope = coroutineScope,
    started = SharingStarted.WhileSubscribed(5000),
    initialValue = initialValue
)