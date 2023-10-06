//
//  LoginView.swift
//  iosApp
//
//  Created by hackline on 6/10/2023.
//  Copyright © 2023 orgName. All rights reserved.
//

import SwiftUI
import SharedSDK

struct LoginView: View {
    
    private let loginViewModel = LoginViewModel()
    
    var body: some View {
        VStack {
            VStack {
                Spacer().frame(height: 36)
                Text("Login Now")
                    .foregroundColor(.textPrimary)
                    .fontWeight(.bold)
                    .font(.system(size: 24))
                
                Text("Welcome back to PlayZone! Enter your email addres and your password to enjoy the latest features of PlayZone")
                    .foregroundColor(.textPrimary.opacity(0.5))
                    .fixedSize(horizontal: false, vertical: true)
                    .multilineTextAlignment(.center)
                    .padding(EdgeInsets(top: 16, leading: 30, bottom: 0, trailing: 30))
                
                Spacer().frame(height: 50)
                
                CommonTextField(hint: "Login", enabled: true, isSecure: false) { newValue in
                    loginViewModel.obtainEvent(viewEvent: .EmailChanged(value: newValue))
                }
            }
            
            HStack {
                
            }
        }
    }
}

#Preview {
    LoginView()
        .background(Color.backgroundPrimary)
}
