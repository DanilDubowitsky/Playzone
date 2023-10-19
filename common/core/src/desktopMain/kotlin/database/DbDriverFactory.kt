package database

import PlatformConfiguration
import com.game.playzone.Database
import com.squareup.sqldelight.db.SqlDriver
import com.squareup.sqldelight.sqlite.driver.JdbcSqliteDriver

actual class DbDriverFactory actual constructor (
    private val platformConfiguration: PlatformConfiguration
) {

    actual fun createDriver(
        schema: SqlDriver.Schema,
        name: String
    ): SqlDriver = JdbcSqliteDriver(JdbcSqliteDriver.IN_MEMORY).also {
        Database.Schema.create(it)
    }
}