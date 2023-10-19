package admin.creategame

import admin.creategame.models.CreateGameAction
import admin.creategame.models.CreateGameEvent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.adeo.kviewmodel.compose.observeAsState
import com.adeo.kviewmodel.odyssey.StoredViewModel
import ru.alexgladkov.odyssey.compose.local.LocalRootController
import widgets.ActionButton
import widgets.CommonTextField

@Composable
fun CreateGameScreen() {
    val rootController = LocalRootController.current

    StoredViewModel({
        CreateGameViewModel()
    }) { viewModel ->
        val viewState = viewModel.viewStates().observeAsState().value
        val viewAction = viewModel.viewActions().observeAsState().value

        Column(modifier = Modifier.padding(16.dp)) {
            CommonTextField(
                text = viewState.title,
                hint = "Game Title",
                enabled = !viewState.isSending,
                onValueChanged = {
                    viewModel.obtainEvent(CreateGameEvent.TitleChanged(it))
                }
            )

            Spacer(modifier = Modifier.height(16.dp))

            CommonTextField(
                text = viewState.description,
                hint = "Description",
                enabled = !viewState.isSending,
                onValueChanged = {
                    viewModel.obtainEvent(CreateGameEvent.DescriptionChanged(it))
                }
            )

            Spacer(modifier = Modifier.height(16.dp))

            CommonTextField(
                text = viewState.version,
                hint = "Version",
                enabled = !viewState.isSending,
                onValueChanged = {
                    viewModel.obtainEvent(CreateGameEvent.VersionChanged(it))
                }
            )

            Spacer(modifier = Modifier.height(16.dp))

            CommonTextField(
                text = viewState.size,
                hint = "Size",
                enabled = !viewState.isSending,
                onValueChanged = {
                    viewModel.obtainEvent(CreateGameEvent.SizeChanged(it))
                }
            )

            Spacer(modifier = Modifier.height(16.dp))

            ActionButton(title = "Save Changes", enabled = !viewState.isSending) {
                viewModel.obtainEvent(CreateGameEvent.SubmitChanges)
            }
        }

        when (viewAction) {
            CreateGameAction.CloseScreen -> rootController.popBackStack()
            null -> {}
        }
    }
}