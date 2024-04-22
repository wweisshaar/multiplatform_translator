package de.wweisshaar.multiplatform_translator.translate.data.translate

@kotlinx.serialization.Serializable
data class TranslateDto(
    val textToTranslate: String,
    val sourceLanguage: String,
    val targetLanguage: String,
)