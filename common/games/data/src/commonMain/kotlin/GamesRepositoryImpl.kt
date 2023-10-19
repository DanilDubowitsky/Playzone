import ktor.KtorGamesDataSource
import ktor.models.KtorSearchGame
import ktor.models.toModel
import ktor.models.toModels
import models.CreateGameInfo
import models.Game
import sqldelight.SqlDelightGamesDataSource

class GamesRepositoryImpl(
    private val remoteDataSource: KtorGamesDataSource,
    private val localDataSource: SqlDelightGamesDataSource
) : GamesRepository {

    override suspend fun fetchAllGames(): List<Game> {
        for (i in 0 until 5) {
            localDataSource.insertGame(KtorSearchGame(
                i.toString(),
                "Game $i",
                "Game description $i",
                "1.2.3",
                "24432"
            ))
        }
        val localGames = localDataSource.fetchLocalGames().map { gamedb ->
            Game(gamedb.game_id, gamedb.game_title)
        }
        return localGames.ifEmpty {
            val remote = remoteDataSource.fetchAllGames()
            remote.forEach { game ->
                localDataSource.insertGame(game)
            }
            remote.map(KtorSearchGame::toModel)
        }
    }

    override suspend fun searchGame(query: String): List<Game> {
        for (i in 0 until 5) {
            localDataSource.insertGame(KtorSearchGame(
                i.toString(),
                "Game $i",
                "Game description $i",
                "1.2.3",
                "24432"
            ))
        }
        return localDataSource.fetchLocalGames().map { gamedb ->
            Game(gamedb.game_id, gamedb.game_title)
        }
    }

    override suspend fun createGame(info: CreateGameInfo) {
        return remoteDataSource.createGame(info)
    }
}
