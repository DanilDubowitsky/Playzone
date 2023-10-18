import json.serializationModule
import ktor.ktorModule
import org.koin.dsl.module
import settings.settingsModule

val coreModule = module {
    includes(ktorModule, serializationModule, settingsModule)
}
