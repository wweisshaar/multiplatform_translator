//
//  LanguageDisplay.swift
//  iosApp
//
//  Created by Waldemar Weisshaar on 29.04.24.
//  Copyright © 2024 orgName. All rights reserved.
//

import SwiftUI
import shared

struct LanguageDisplay: View {
    let language: UiLanguage
    var body: some View {
        HStack {
            SmallLanguageIcon(language: language)
                .padding(.trailing, 5)
            Text(language.language.langName)
                .foregroundStyle(Color.lightBlue)
        }
    }
}

#Preview {
    LanguageDisplay(
        language: UiLanguage(language: .german, imageName: "german")
    )
}
