
import json.serializationModule
import ktor.ktorModule
import org.koin.core.annotation.Module
import org.koin.dsl.module
import settings.SettingsModule

@Module(includes = [SettingsModule::class])
class CoreModule
