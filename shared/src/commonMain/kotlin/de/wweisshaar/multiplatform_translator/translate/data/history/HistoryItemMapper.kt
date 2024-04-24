package de.wweisshaar.multiplatform_translator.translate.data.history

import database.HistoryEntity
import de.wweisshaar.multiplatform_translator.translate.domain.history.HistoryItem

fun HistoryEntity.toHistoryItem(): HistoryItem {
    return HistoryItem(
        id = id,
        fromLanguageCode = fromLanguageCode,
        fromText = fromText,
        toLanguageCode = toLanguageCode,
        toText = toText
    )
}