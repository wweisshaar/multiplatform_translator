package de.wweisshaar.multiplatform_translator

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform