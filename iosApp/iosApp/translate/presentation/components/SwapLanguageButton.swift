//
//  SwapLanguageButton.swift
//  iosApp
//
//  Created by Waldemar Weisshaar on 29.04.24.
//  Copyright © 2024 orgName. All rights reserved.
//

import SwiftUI
import shared

struct SwapLanguageButton: View {
    let onClick: () -> Void
    var body: some View {
        Button(action: onClick) {
            Image(uiImage: UIImage(named: "swap_languages")!)
                .padding()
                .background(Color.primaryColor)
                .clipShape(Circle())
        }
    }
}

#Preview {
    SwapLanguageButton(onClick: {})
}
