package de.wweisshaar.multiplatform_translator.translate.domain.history

import de.wweisshaar.multiplatform_translator.core.domain.util.CommonFlow

interface HistoryDataSource {
    fun getHistory(): CommonFlow<List<HistoryItem>>
    suspend fun insertHistory(item: HistoryItem)
}