import ktor.KtorGamesDataSource
import org.koin.dsl.module
import sqldelight.SqlDelightGamesDataSource

val gamesModule = module {
    factory {
        KtorGamesDataSource(get())
    }

    factory {
        SqlDelightGamesDataSource()
    }

    single<GamesRepository> {
        GamesRepositoryImpl(get(), get())
    }
}
