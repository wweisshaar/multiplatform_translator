package de.wweisshaar.multiplatform_translator.android.translate.presentation.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.BoxWithConstraints
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowUp
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import de.wweisshaar.multiplatform_translator.android.R
import de.wweisshaar.multiplatform_translator.android.core.theme.LightBlue
import de.wweisshaar.multiplatform_translator.core.presentation.UiLanguage

@Composable
fun LanguageDropDown(
    language: UiLanguage,
    isOpen: Boolean,
    onClick: () -> Unit,
    onDismiss: () -> Unit,
    onSelectLanguage: (UiLanguage) -> Unit,
    modifier: Modifier = Modifier
) {
    BoxWithConstraints(modifier = modifier) {
        val textStyle = when (maxWidth) {
            in 0.dp..320.dp -> MaterialTheme.typography.labelMedium
            in 321.dp..480.dp -> MaterialTheme.typography.bodyMedium
            else -> MaterialTheme.typography.bodyMedium
        }
        DropdownMenu(
            expanded = isOpen,
            onDismissRequest = onDismiss
        ) {
            UiLanguage.allLanguages.forEach { language ->
                LanguageDropDownItem(
                    language = language,
                    onClick = { onSelectLanguage(language) },
                    modifier = Modifier.fillMaxWidth()
                )
            }
        }
        Row(
            modifier = Modifier
                .clickable(onClick = onClick)
                .padding(16.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            AsyncImage(
                model = language.drawableResId,
                contentDescription = language.language.langName,
                modifier = Modifier.size(30.dp),
                contentScale = ContentScale.FillBounds,
            )
            Spacer(modifier = Modifier.width(8.dp))
            Text(
                text = language.language.langName,
                color = LightBlue,
                style = textStyle
            )
            Icon(
                imageVector = if (isOpen) Icons.Default.KeyboardArrowUp else Icons.Default.KeyboardArrowUp,
                contentDescription = if (isOpen) {
                    stringResource(id = R.string.close)
                } else {
                    stringResource(id = R.string.open)
                },
                tint = LightBlue,
                modifier = Modifier.size(30.dp)
            )
        }
    }
}