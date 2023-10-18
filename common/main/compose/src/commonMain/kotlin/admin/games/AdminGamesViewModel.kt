package admin.games

import GamesRepository
import admin.events.models.AdminEventsAction
import admin.events.models.AdminEventsEvent
import admin.events.models.AdminGamesViewState
import admin.games.models.AdminGamesAction
import admin.games.models.AdminGamesEvent
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

    }

    private fun fetchAllGames() {
        viewModelScope.launch {
            val games = gamesRepository.fetchAllGames()
            viewState = viewState
        }
    }

}