package admin.creategame

import AuthRepository
import GamesRepository
import admin.creategame.models.CreateGameAction
import admin.creategame.models.CreateGameEvent
import admin.creategame.models.CreateGameViewState
import com.adeo.kviewmodel.BaseSharedViewModel
import kotlinx.coroutines.launch
import models.CreateGameInfo
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject

class CreateGameViewModel :
    BaseSharedViewModel<CreateGameViewState, CreateGameAction, CreateGameEvent>(
        CreateGameViewState()
    ), KoinComponent {

    private val gameRepository: GamesRepository by inject()

    override fun obtainEvent(viewEvent: CreateGameEvent) = when (viewEvent) {
        is CreateGameEvent.DescriptionChanged -> viewState =
            viewState.copy(description = viewEvent.description)

        is CreateGameEvent.SizeChanged -> viewState = viewState.copy(size = viewEvent.size)

        CreateGameEvent.SubmitChanges -> submitChanges()

        is CreateGameEvent.TitleChanged -> viewState = viewState.copy(title = viewEvent.title)

        is CreateGameEvent.VersionChanged -> viewState = viewState.copy(version = viewEvent.version)
    }

    private fun submitChanges() {
        viewModelScope.launch {
            viewState = viewState.copy(isSending = true)

            viewState = try {
                gameRepository.createGame(CreateGameInfo(
                    viewState.title,
                    viewState.description,
                    viewState.size.toDouble(),
                    viewState.version
                ))

                viewAction = CreateGameAction.CloseScreen
                viewState.copy(isSending = false)
            } catch (e: Exception) {
                viewState.copy(isSending = false)
            }
        }
    }

}