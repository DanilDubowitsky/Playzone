import database.databaseModule
import org.koin.core.context.startKoin

fun initKoin(configuration: PlatformConfiguration) {
    startKoin {
        modules(gamesModule, authModule, coreModule, databaseModule(configuration))
    }
}
