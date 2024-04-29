//
//  ProgressButton.swift
//  iosApp
//
//  Created by Waldemar Weisshaar on 29.04.24.
//  Copyright © 2024 orgName. All rights reserved.
//

import SwiftUI
import shared

struct ProgressButton: View {
    var text: String
    var isLoading: Bool
    var onClick: () -> Void
    
    var body: some View {
        Button(
            action: {
                if isLoading {
                    onClick()
                }
            }
        ) {
            if isLoading {
                ProgressView()
                    .animation(.easeOut, value: isLoading)
                    .padding(5)
                    .background(Color.primaryColor)
                    .cornerRadius(100)
                    .progressViewStyle(CircularProgressViewStyle(tint: .white))
            } else {
                Text(text.uppercased())
                    .animation(.easeOut, value: isLoading)
                    .padding(.horizontal)
                    .padding(.vertical, 5)
                    .font(.body.weight(.bold))
                    .background(Color.primaryColor)
                    .foregroundStyle(Color.onPrimary)
                    .cornerRadius(100)
                
            }
        }
    }
}

#Preview {
    ProgressButton(
        text: "Translate", isLoading: false, onClick: {}
    )
}
