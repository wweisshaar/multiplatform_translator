package de.wweisshaar.multiplatform_translator.core.domain.util

import kotlinx.coroutines.flow.MutableStateFlow

expect class CommonMutableStateFlow<T>(mutableStateFlow: MutableStateFlow<T>) : MutableStateFlow<T>

fun <T> MutableStateFlow<T>.toCommonMutableStateFlow(): MutableStateFlow<T> =
    CommonMutableStateFlow(this)