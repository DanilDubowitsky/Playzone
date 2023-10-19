import SwiftUI
import SharedSDK

@main
struct iOSApp: App {
    
    init() {
        HelperKt.doInitKoin(configuration: PlatformConfiguration())
    }
    
    var body: some Scene {
        WindowGroup {
            ContentView()
        }
    }
    
}
