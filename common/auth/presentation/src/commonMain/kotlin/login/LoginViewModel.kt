package login

import AuthRepository
import com.adeo.kviewmodel.BaseSharedViewModel
import kotlinx.coroutines.launch
import login.models.LoginAction
import login.models.LoginEvent
import login.models.LoginViewState
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject

class LoginViewModel : BaseSharedViewModel<LoginViewState, LoginAction, LoginEvent>(
    initialState = LoginViewState()
), KoinComponent {

    private val authRepository: AuthRepository by inject()

    init {
        checkUserLoggedIn()
    }

    override fun obtainEvent(viewEvent: LoginEvent) = when (viewEvent) {
        is LoginEvent.EmailChanged -> obtainEmailChanged(viewEvent.value)

        is LoginEvent.ForgotClick -> openForgot()

        is LoginEvent.LoginClick -> sendLogin()

        is LoginEvent.PasswordChanged -> obtainPasswordChanged(viewEvent.value)

        is LoginEvent.RegistrationClick -> openRegistration()

        is LoginEvent.PasswordShowClick -> changePasswordVisibility()
    }

    private fun checkUserLoggedIn() {
         if (authRepository.isUserLoggedIn()) {
             viewAction = LoginAction.OpenMainFlow
         }
    }

    private fun sendLogin() {
        viewState = viewState.copy(isSending = true)
        viewModelScope.launch {
             try {
                val response = authRepository.login(viewState.email, viewState.password)
                if (response.token.isNotEmpty()) {
                    viewState = viewState.copy(email = "", password = "", isSending = false)
                    viewAction = LoginAction.OpenMainFlow
                } else {
                    viewState = viewState.copy(isSending = false)
                }
            } catch (e: Exception) {
                 viewState = viewState.copy(isSending = false)
            }
        }
    }

    private fun changePasswordVisibility() {
        viewState = viewState.copy(passwordHidden = !viewState.passwordHidden)
    }

    private fun obtainEmailChanged(value: String) {
        viewState = viewState.copy(email = value)
    }

    private fun obtainPasswordChanged(value: String) {
        viewState = viewState.copy(password = value)
    }

    private fun openForgot() {
        viewAction = LoginAction.OpenForgotPasswordScreen
    }

    private fun openRegistration() {
        viewAction = LoginAction.OpenRegistrationScreen
    }

}
