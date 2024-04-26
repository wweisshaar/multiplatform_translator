package de.wweisshaar.multiplatform_translator.android

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Shapes
import androidx.compose.material3.Typography
import androidx.compose.runtime.Composable
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import de.wweisshaar.multiplatform_translator.android.core.theme.darkColors
import de.wweisshaar.multiplatform_translator.android.core.theme.lightColors

@Composable
fun TranslatorTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    content: @Composable () -> Unit
) {
    val colors = if (darkTheme) {
        darkColors
    } else {
        lightColors
    }
    val SfProText = FontFamily(
        Font(
            resId = R.font.sf_pro_text_regular,
            weight = FontWeight.Normal,
        ),
        Font(
            resId = R.font.sf_pro_text_medium,
            weight = FontWeight.Medium,
        ),
        Font(
            resId = R.font.sf_pro_text_bold,
            weight = FontWeight.Bold,
        )
    )
    val typography = Typography(
        headlineLarge = TextStyle(
            fontFamily = SfProText,
            fontWeight = FontWeight.Bold,
            fontSize = 30.sp,
        ),
        headlineMedium = TextStyle(
            fontFamily = SfProText,
            fontWeight = FontWeight.Bold,
            fontSize = 24.sp,
        ),
        headlineSmall = TextStyle(
            fontFamily = SfProText,
            fontWeight = FontWeight.Medium,
            fontSize = 18.sp,
        ),
        bodyLarge = TextStyle(
            fontFamily = SfProText,
            fontWeight = FontWeight.Bold,
            fontSize = 20.sp
        ),
        bodyMedium = TextStyle(
            fontFamily = SfProText,
            fontWeight = FontWeight.Normal,
            fontSize = 14.sp
        ),
        bodySmall = TextStyle(
            fontFamily = SfProText,
            fontWeight = FontWeight.Normal,
            fontSize = 8.sp
        )
    )
    val shapes = Shapes(
        small = RoundedCornerShape(4.dp),
        medium = RoundedCornerShape(4.dp),
        large = RoundedCornerShape(0.dp)
    )

    MaterialTheme(
        colorScheme = colors,
        typography = typography,
        shapes = shapes,
        content = content
    )
}
