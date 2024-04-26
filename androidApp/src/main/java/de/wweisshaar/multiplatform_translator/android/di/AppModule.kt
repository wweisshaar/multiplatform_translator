package de.wweisshaar.multiplatform_translator.android.di

import android.app.Application
import app.cash.sqldelight.db.SqlDriver
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import de.wweisshaar.multiplatform_translator.database.TranslateDatabase
import de.wweisshaar.multiplatform_translator.translate.data.history.SqlDelightHistoryDataSource
import de.wweisshaar.multiplatform_translator.translate.data.local.DatabaseDriverFactory
import de.wweisshaar.multiplatform_translator.translate.data.remote.HttpClientFactory
import de.wweisshaar.multiplatform_translator.translate.data.translate.KtorTranslateClient
import de.wweisshaar.multiplatform_translator.translate.domain.history.HistoryDataSource
import de.wweisshaar.multiplatform_translator.translate.domain.translate.Translate
import de.wweisshaar.multiplatform_translator.translate.domain.translate.TranslateClient
import io.ktor.client.*
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {
    @Provides
    @Singleton
    fun provideHttpClient(): HttpClient {
        return HttpClientFactory().create()
    }

    @Provides
    @Singleton
    fun provideTranslateClient(httpClient: HttpClient): TranslateClient {
        return KtorTranslateClient(httpClient)
    }

    @Provides
    @Singleton
    fun provideDatabaseDriver(app: Application): SqlDriver {
        return DatabaseDriverFactory(app).create()
    }

    @Provides
    @Singleton
    fun provideHistoryDataSource(driver: SqlDriver): HistoryDataSource {
        return SqlDelightHistoryDataSource(TranslateDatabase(driver))
    }

    @Provides
    @Singleton
    fun provideTranslateUseCase(
        client: TranslateClient,
        dataSource: HistoryDataSource
    ): Translate {
        return Translate(client, dataSource)
    }
}