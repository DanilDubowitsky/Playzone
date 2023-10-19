package admin.games.models

sealed class AdminGamesEvent {

    object AddGameClicked : AdminGamesEvent()
}
