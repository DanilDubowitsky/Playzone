//
//  HomeScreen.swift
//  iosApp
//
//  Created by hackline on 16/10/2023.
//  Copyright © 2023 orgName. All rights reserved.
//

import SwiftUI
import SharedSDK

struct HomeScreen: View {
    
    private let homeViewModel = HomeViewModel()
    @State private var isProfilePresented = false
    
    var body: some View {
        ObservingView(statePublisher: statePublisher(homeViewModel.viewStates())) { viewState in
            HomeView(viewState: viewState) { event in
                homeViewModel.obtainEvent(viewEvent: event)
            }
        }
        .sheet(isPresented: $isProfilePresented) {
            Text("Hello, Profile")
        }
        .onReceive(sharePublisher(homeViewModel.viewActions())) { action in
            switch (action) {
            case HomeAction.ShowUserProfile():
                isProfilePresented = true
            default:
                break
            }
        }
    }
}

struct HomeScreen_Previews: PreviewProvider {
    static var previews: some View {
        HomeScreen()
    }
}
