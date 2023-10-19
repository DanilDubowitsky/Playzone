package ktor.models

import kotlinx.serialization.Serializable

@Serializable
data class KtorCreateGameRequest(
    val title: String,
    val description: String,
    val version: String,
    val size: Double
)