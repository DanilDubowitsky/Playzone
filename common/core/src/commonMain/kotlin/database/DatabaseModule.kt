package database

import PlatformConfiguration
import com.game.playzone.Database
import org.koin.dsl.module

fun databaseModule(platformConfiguration: PlatformConfiguration) = module {
    single {
        DbDriverFactory(platformConfiguration)
    }

    single {
        val driverFactory = get<DbDriverFactory>()
        val driver = driverFactory.createDriver(Database.Schema, "PlayzoneDb")

        Database(driver)
    }
}
