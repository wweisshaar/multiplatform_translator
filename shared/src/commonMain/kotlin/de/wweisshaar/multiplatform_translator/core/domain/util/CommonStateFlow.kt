package de.wweisshaar.multiplatform_translator.core.domain.util

import kotlinx.coroutines.flow.StateFlow

expect class CommonStateFlow<T>(stateFlow: StateFlow<T>) : StateFlow<T>

fun <T> StateFlow<T>.toCommonStateFlow(): CommonStateFlow<T> = CommonStateFlow(this)