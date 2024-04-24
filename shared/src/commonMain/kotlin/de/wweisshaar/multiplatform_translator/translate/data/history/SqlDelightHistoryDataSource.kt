package de.wweisshaar.multiplatform_translator.translate.data.history

import app.cash.sqldelight.coroutines.asFlow
import app.cash.sqldelight.coroutines.mapToList
import database.TranslateQueries
import de.wweisshaar.multiplatform_translator.core.domain.util.CommonFlow
import de.wweisshaar.multiplatform_translator.core.domain.util.toCommonFlow
import de.wweisshaar.multiplatform_translator.database.TranslateDatabase
import de.wweisshaar.multiplatform_translator.translate.domain.history.HistoryDataSource
import de.wweisshaar.multiplatform_translator.translate.domain.history.HistoryItem
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.IO
import kotlinx.coroutines.flow.map
import kotlinx.datetime.Clock

class SqlDelightHistoryDataSource(
    private val db: TranslateDatabase
) : HistoryDataSource {

    private val queries: TranslateQueries = db.translateQueries

    override fun getHistory(): CommonFlow<List<HistoryItem>> {
        return queries
            .getHistory()
            .asFlow()
            .mapToList(Dispatchers.IO)
            .map { history ->
                history.map { it.toHistoryItem() }
            }
            .toCommonFlow()
    }

    override suspend fun insertHistory(item: HistoryItem) {
        queries.insertHistoryEntity(
            item.id,
            item.fromLanguageCode,
            item.fromText,
            item.toLanguageCode,
            item.toText,
            Clock.System.now().toEpochMilliseconds()
        )
    }
}