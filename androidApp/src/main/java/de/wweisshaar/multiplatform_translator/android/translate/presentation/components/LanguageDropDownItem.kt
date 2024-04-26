package de.wweisshaar.multiplatform_translator.android.translate.presentation.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.size
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import de.wweisshaar.multiplatform_translator.core.presentation.UiLanguage

@Composable
fun LanguageDropDownItem(
    language: UiLanguage,
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
) {
    DropdownMenuItem(
        onClick = onClick,
        modifier = modifier,
        text = { Text(text = language.language.langName) },
        contentPadding = PaddingValues(16.dp),
        leadingIcon = {
            Image(
                painter = painterResource(id = language.drawableResId),
                contentDescription = language.language.langName,
                modifier = Modifier.size(40.dp)
            )
        }
    )
}