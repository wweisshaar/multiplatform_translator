package de.wweisshaar.multiplatform_translator.translate.domain.translate

import de.wweisshaar.multiplatform_translator.core.domain.language.Language
import de.wweisshaar.multiplatform_translator.core.domain.util.Result
import de.wweisshaar.multiplatform_translator.translate.domain.history.HistoryDataSource
import de.wweisshaar.multiplatform_translator.translate.domain.history.HistoryItem

class Translate(
    private val client: TranslateClient,
    private val historyDataSource: HistoryDataSource
) {
    suspend fun execute(
        fromLanguage: Language,
        fromText: String,
        toLanguage: Language,
    ): Result<String, TranslateError> {
        return try {
            val translatedText = client.translate(
                fromLanguage = fromLanguage, fromText = fromText, toLanguage = toLanguage
            )
            historyDataSource.insertHistoryItem(
                HistoryItem(
                    id = null,
                    fromLanguageCode = fromLanguage.langCode,
                    fromText = fromText,
                    toLanguageCode = toLanguage.langCode,
                    toText = translatedText
                )
            )
            Result.Success(translatedText)
        } catch (e: Exception) {
            e.printStackTrace()
            if (e is TranslateException) {
                Result.Error(e.error)
            } else {
                Result.Error(TranslateError.UNKNOWN_ERROR)
            }
        }
    }
}