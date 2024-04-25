package de.wweisshaar.multiplatform_translator.translate.presentation

import de.wweisshaar.multiplatform_translator.core.presentation.UiLanguage

data class UiHistoryItem(
    val id: Long,
    val fromText: String,
    val toText: String,
    val fromLanguage: UiLanguage,
    val toLanguage: UiLanguage,
)