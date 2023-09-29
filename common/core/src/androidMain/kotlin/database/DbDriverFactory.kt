package database

import com.squareup.sqldelight.db.SqlDriver
import platform.PlatformConfiguration

//actual class DbDriverFactory actual constructor (
//    private val platformConfiguration: PlatformConfiguration
//) {
//
//    actual fun createDriver(
//        schema: SqlDriver.Schema,
//        name: String
//    ): SqlDriver = AndroidSqliteDriver(schema, platformConfiguration.context, name)
//}