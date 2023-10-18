package search

import GamesRepository
import com.adeo.kviewmodel.BaseSharedViewModel
import kotlinx.coroutines.Job
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject
import search.models.SearchAction
import search.models.SearchEvent
import search.models.SearchViewState

class SearchViewModel : BaseSharedViewModel<SearchViewState, SearchAction, SearchEvent>(
    SearchViewState("")
), KoinComponent {

    private val gamesRepository: GamesRepository by inject()
    private var searchJob: Job? = null

    override fun obtainEvent(viewEvent: SearchEvent) =
        when (viewEvent) {
            SearchEvent.GameClicked -> showDetailedGame()
            is SearchEvent.QueryChanged -> searchGame(query = viewEvent.query)
        }

    private fun searchGame(query: String) {
        searchJob = viewModelScope.launch {
            viewState = viewState.copy(query = query)
            searchJob?.cancel()
            delay(500)
            viewState = try {
                val games = gamesRepository.searchGame(query)
                viewState.copy(games = games)
            } catch (e: Exception) {
                viewState.copy(games = emptyList())
            }
        }
    }

    private fun showDetailedGame() {
        viewAction = SearchAction.ShowGameDetails
    }




}