package admin.games

import GamesRepository
import admin.games.models.AdminGamesAction
import admin.games.models.AdminGamesEvent
import admin.games.models.AdminGamesViewState
import com.adeo.kviewmodel.BaseSharedViewModel
import kotlinx.coroutines.launch
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject

class AdminGamesViewModel :
    BaseSharedViewModel<AdminGamesViewState, AdminGamesAction, AdminGamesEvent>(
        AdminGamesViewState()
    ), KoinComponent {

    private val gamesRepository: GamesRepository by inject()

    init {
        fetchAllGames()
    }

    override fun obtainEvent(viewEvent: AdminGamesEvent) {
        when (viewEvent) {
            AdminGamesEvent.AddGameClicked -> {
                viewAction = AdminGamesAction.ShowAddGame
            }
        }
    }

    private fun fetchAllGames() {
        viewModelScope.launch {
            val games = gamesRepository.fetchAllGames()
            viewState = viewState.copy(games = games)
        }
    }

}