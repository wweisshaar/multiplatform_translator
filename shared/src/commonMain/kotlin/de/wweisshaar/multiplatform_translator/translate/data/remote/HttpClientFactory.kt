package de.wweisshaar.multiplatform_translator.translate.data.remote

import io.ktor.client.*

expect class HttpClientFactory {
    fun create(): HttpClient
}