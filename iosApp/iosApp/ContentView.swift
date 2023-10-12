import SwiftUI

struct ContentView: View {
    
    var body: some View {
       LoginView()
            .background(Color.backgroundPrimary)
            .background(ignoresSafeAreaEdges: [.top, .bottom, .leading, .trailing])
    }
}

struct ContentView_Previews: PreviewProvider {
    static var previews: some View {
        ContentView()
    }
}
