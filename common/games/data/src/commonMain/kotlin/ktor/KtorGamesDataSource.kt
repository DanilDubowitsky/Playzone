package ktor

import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.request.header
import io.ktor.client.request.post
import io.ktor.client.request.request
import io.ktor.client.request.setBody
import io.ktor.http.URLProtocol
import io.ktor.http.path
import ktor.models.KtorSearchGame
import ktor.models.KtorSearchRequest
import ktor.models.toModel
import ktor.models.toModels
import models.Game

class KtorGamesDataSource(
    private val httpClient: HttpClient
) {

    suspend fun fetchAllGames(): List<KtorSearchGame> {
        return httpClient.post {
            url {
                path("games/search")
                setBody(KtorSearchRequest(searchQuery = ""))
            }
        }.body()
    }

    suspend fun searchGame(query: String): List<KtorSearchGame> {
        return httpClient.post {
            url {
                path("games/search")
                setBody(KtorSearchRequest(searchQuery = query))
            }
        }.body()
    }

}
