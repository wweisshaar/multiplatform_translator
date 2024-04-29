//
//  TranslateScreen.swift
//  iosApp
//
//  Created by Waldemar Weisshaar on 29.04.24.
//  Copyright © 2024 orgName. All rights reserved.
//

import SwiftUI
import shared

struct TranslateScreen: View {
    private var hisoryDataSource: HistoryDataSource
    private var translateUsesCase: Translate
    @ObservedObject var viewModel: IOSTranslateViewModel
    
    init(hisoryDataSource: HistoryDataSource, translateUsesCase: Translate) {
        self.hisoryDataSource = hisoryDataSource
        self.translateUsesCase = translateUsesCase
        self.viewModel = IOSTranslateViewModel(
            historyDataSource: hisoryDataSource,
            translateUseCase: translateUsesCase
        )
    }
    
    var body: some View {
        ZStack {
            List {
                HStack(alignment: .center) {
                    LanguageDropDown(
                        language: viewModel.state.fromLanguage,
                        isOpen: viewModel.state.isChoosingFromLanguage,
                        selectLanguage: { language in
                            viewModel.onEvent(event: TranslateEvent.ChooseFromLanguage(language: language))
                        }
                    )
                    Spacer()
                    SwapLanguageButton(onClick: {
                        viewModel.onEvent(event: TranslateEvent.SwapLanguages())
                    })
                    Spacer()
                    LanguageDropDown(
                        language: viewModel.state.toLanguage,
                        isOpen: viewModel.state.isChoosingToLanguage,
                        selectLanguage: { language in
                            viewModel.onEvent(event: TranslateEvent.ChooseToLanguage(language: language))
                        }
                    )
                }
                .listRowSeparator(.hidden)
                .listRowBackground(Color.background)
                
                TranslateTextField(
                    fromText: Binding(get: { viewModel.state.fromText }, set: { value in
                        viewModel.onEvent(event: TranslateEvent.ChangeTranslationText(text: value))
                    }),
                    toText: viewModel.state.toText,
                    isTranslating: viewModel.state.isTranslating,
                    fromLanguage: viewModel.state.fromLanguage,
                    toLanguage: viewModel.state.toLanguage,
                    onTranslateEvent: { event in
                        viewModel.onEvent(event: event)
                    }
                )
                .listRowSeparator(.hidden)
                .listRowBackground(Color.background)
            }
            .listStyle(.plain)
            .buttonStyle(.plain)
        }
        .onAppear {
            viewModel.startObserving()
        }
        .onDisappear {
            viewModel.dispose()
        }
    }
}
