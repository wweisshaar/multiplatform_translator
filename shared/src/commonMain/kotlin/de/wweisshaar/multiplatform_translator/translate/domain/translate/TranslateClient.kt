package de.wweisshaar.multiplatform_translator.translate.domain.translate

import de.wweisshaar.multiplatform_translator.core.domain.language.Language

interface TranslateClient {
    suspend fun translate(
        fromLanguage: Language,
        fromText: String,
        toLanguage: Language,
    ): String
}