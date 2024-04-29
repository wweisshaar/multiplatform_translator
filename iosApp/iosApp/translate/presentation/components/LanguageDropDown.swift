//
//  LanguageDropDown.swift
//  iosApp
//
//  Created by Waldemar Weisshaar on 29.04.24.
//  Copyright © 2024 orgName. All rights reserved.
//

import SwiftUI
import shared

struct LanguageDropDown: View {
    var language: UiLanguage
    var isOpen: Bool
    var selectLanguage: (UiLanguage) -> Void
    
    var body: some View {
        Menu {
            VStack {
                ForEach(UiLanguage.companion.allLanguages, id: \.language.langCode) { language in
                    LanguageDropDownItem(language: language, onClick: {
                        selectLanguage(language)
                    })
                }
            }
        } label: {
            HStack {
                SmallLanguageIcon(language: language)
                Text(language.language.langName)
                    .foregroundStyle(Color.lightBlue)
                Image(systemName: isOpen ? "chevron.up" : "chevron.down")
                    .foregroundStyle(Color.lightBlue)
            }
        }
    }
}

#Preview {
    LanguageDropDown(language: UiLanguage(language: .german, imageName: "german"), isOpen: true, selectLanguage: {language in})
}
