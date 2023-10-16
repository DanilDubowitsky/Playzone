package settings

import com.russhwolf.settings.Settings
import com.russhwolf.settings.get

class SettingsAuthDataSource(
    private val settings: Settings
) {

    fun saveToken(token: String) {
        settings.putString(TOKEN_KEY, token)
    }

    fun fetchToken(): String =
        settings[TOKEN_KEY, ""]

    private companion object {
        const val TOKEN_KEY = "token"
    }

}