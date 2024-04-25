package de.wweisshaar.multiplatform_translator.core.presentation

import de.wweisshaar.multiplatform_translator.core.domain.language.Language

expect class UiLanguage {

    val language: Language

    companion object {
        fun byCode(langCode: String): UiLanguage
        val allLanguages: List<UiLanguage>
    }
}