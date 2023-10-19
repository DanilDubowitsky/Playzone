package sqldelight

import com.game.playzone.Database
import databases.GAMEDB
import ktor.models.KtorSearchGame
import models.Game

class SqlDelightGamesDataSource(
    private val database: Database
) {

    fun fetchLocalGames(): List<GAMEDB> {
        return database.gameQueries.getAllGames().executeAsList()
    }

    fun insertGame(game: KtorSearchGame) {
        database.gameQueries.insertGame(game.gameId, game.title, game.version, game.size)
    }
}