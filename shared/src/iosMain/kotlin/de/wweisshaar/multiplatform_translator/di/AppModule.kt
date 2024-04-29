package de.wweisshaar.multiplatform_translator.di

import de.wweisshaar.multiplatform_translator.database.TranslateDatabase
import de.wweisshaar.multiplatform_translator.translate.data.history.SqlDelightHistoryDataSource
import de.wweisshaar.multiplatform_translator.translate.data.local.DatabaseDriverFactory
import de.wweisshaar.multiplatform_translator.translate.data.remote.HttpClientFactory
import de.wweisshaar.multiplatform_translator.translate.data.translate.KtorTranslateClient
import de.wweisshaar.multiplatform_translator.translate.domain.history.HistoryDataSource
import de.wweisshaar.multiplatform_translator.translate.domain.translate.Translate
import de.wweisshaar.multiplatform_translator.translate.domain.translate.TranslateClient

class AppModule {
    val historyDataSource: HistoryDataSource by lazy {
        SqlDelightHistoryDataSource(
            db = TranslateDatabase(
                driver = DatabaseDriverFactory().create()
            )
        )
    }

    private val translateClient: TranslateClient by lazy {
        KtorTranslateClient(
            httpClient = HttpClientFactory().create()
        )
    }

    val translateUseCase: Translate by lazy {
        Translate(
            client = translateClient,
            historyDataSource = historyDataSource
        )
    }
}