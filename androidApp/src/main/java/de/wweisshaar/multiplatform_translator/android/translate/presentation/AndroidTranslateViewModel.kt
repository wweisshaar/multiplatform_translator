package de.wweisshaar.multiplatform_translator.android.translate.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import de.wweisshaar.multiplatform_translator.translate.domain.history.HistoryDataSource
import de.wweisshaar.multiplatform_translator.translate.domain.translate.Translate
import de.wweisshaar.multiplatform_translator.translate.presentation.TranslateEvent
import de.wweisshaar.multiplatform_translator.translate.presentation.TranslateViewModel
import javax.inject.Inject

@HiltViewModel
class AndroidTranslateViewModel @Inject constructor(
    private val translate: Translate,
    private val historyDataSource: HistoryDataSource
) : ViewModel() {

    private val viewModel by lazy {
        TranslateViewModel(
            translate = translate,
            historyDataSource = historyDataSource,
            coroutineScope = viewModelScope
        )
    }

    val state = viewModel.state

    fun onEvent(event: TranslateEvent) {
        viewModel.onEvent(event)
    }
}