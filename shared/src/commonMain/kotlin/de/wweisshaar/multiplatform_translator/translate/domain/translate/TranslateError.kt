package de.wweisshaar.multiplatform_translator.translate.domain.translate

import de.wweisshaar.multiplatform_translator.core.domain.util.Error

enum class TranslateError: Error {
    SERVICE_UNAVAILABLE,
    CLIENT_ERROR,
    SERVER_ERROR,
    UNKNOWN_ERROR
}

class TranslateException(val error: TranslateError): Exception("An error occurred when translating: $error")