import ktor.KtorGamesDataSource
import ktor.models.KtorSearchGame
import ktor.models.toModel
import ktor.models.toModels
import models.Game
import sqldelight.SqlDelightGamesDataSource

class GamesRepositoryImpl(
    private val remoteDataSource: KtorGamesDataSource,
    private val localDataSource: SqlDelightGamesDataSource
) : GamesRepository {

    override suspend fun fetchAllGames(): List<Game> {
        return remoteDataSource.fetchAllGames().map(KtorSearchGame::toModel)
    }

    override suspend fun searchGame(query: String): List<Game> {
        return remoteDataSource.searchGame(query).toModels()
    }
}
