package com.madonasyombua.samplelogin.util

import androidx.lifecycle.SavedStateHandle
import kotlinx.coroutines.flow.MutableStateFlow

/**
 * A class that act as a [MutableStateFlow] but
 * saves the value and retrieves it upon process death
 * with the help of [SavedStateHandle]
 */
class MutableSavedState<T>(
    private val savedStateHandle: SavedStateHandle,
    private val key: String,
    defValue: T,
) {
    private val _state: MutableStateFlow<T> = MutableStateFlow(
        savedStateHandle.get<T>(key) ?: defValue
    )

    var value: T
        get() = _state.value
        set(value) {
            _state.value = value
            savedStateHandle[key] = value
        }

    val flow get() = _state
}

