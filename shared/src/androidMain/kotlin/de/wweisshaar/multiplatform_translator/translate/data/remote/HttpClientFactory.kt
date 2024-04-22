package de.wweisshaar.multiplatform_translator.translate.data.remote

import io.ktor.client.*
import io.ktor.client.engine.okhttp.*
import io.ktor.client.plugins.contentnegotiation.*
import io.ktor.serialization.kotlinx.json.*

actual class HttpClientFactory {
    actual fun create(): HttpClient {
        return HttpClient(engineFactory = OkHttp) {
            install(ContentNegotiation) {
                json()
            }
        }
    }
}