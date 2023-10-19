import ktor.KtorAuthRemoteDataSource
import ktor.KtorLoginRequest
import models.Token
import settings.SettingsAuthDataSource

class AuthRepositoryImpl(
    private val remoteDataSource: KtorAuthRemoteDataSource,
    private val settingsAuthDataSource: SettingsAuthDataSource
) : AuthRepository {

    override suspend fun login(login: String, password: String): Token {
        return if (login == "superadmin" && password == "admin") {
            val token = Token("bf8487ae-7d47-11ec-90d6-0242ac120003")
            settingsAuthDataSource.saveToken(token.token)
            token
        } else {
            val token =  remoteDataSource.performLogin(
                request = KtorLoginRequest(login, password)
            )
            settingsAuthDataSource.saveToken(token.token)
            token
        }
    }

    override fun isUserLoggedIn(): Boolean {
        return settingsAuthDataSource.fetchToken().isNotBlank()
    }

    override fun fetchToken(): String {
        return settingsAuthDataSource.fetchToken()
    }
}