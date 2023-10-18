package navigation

import SplashScreen
import admin.navigation.adminFlow
import androidx.compose.material.Text
import androidx.compose.ui.graphics.Color
import ru.alexgladkov.odyssey.compose.extensions.screen
import ru.alexgladkov.odyssey.compose.navigation.RootComposeBuilder

enum class NavigationSource {
    Desktop,
    Android
}

fun RootComposeBuilder.generateGraph(source: NavigationSource) {
    screen(name = NavigationTree.Splash.SplashScreen.name) {
        SplashScreen()
    }

    screen(name = NavigationTree.Main.Game.name) {
        Text(text = "Hello Game Detail", color = Color.White)
    }

    authFlow()

    when (source) {
        NavigationSource.Desktop -> adminFlow()
        NavigationSource.Android -> mainFlow()
    }
}
