package com.example.first_movile_app.ui.theme

import android.os.Build
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.dynamicDarkColorScheme
import androidx.compose.material3.dynamicLightColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext

private val LightColorScheme = lightColorScheme(
    // Elementos principales
    primary = LightPrimary,
    onPrimary = Color.White,
    primaryContainer = LightSecondary,
    onPrimaryContainer = LightPrimary,

    // Elementos secundarios
    secondary = LightSecondary,
    onSecondary = LightText,
    secondaryContainer = LightSecondary.copy(alpha = 0.3f),
    onSecondaryContainer = LightPrimary,

    // Fondo y superficie
    background = LightBackground,
    onBackground = LightText,
    surface = LightBackground,
    onSurface = LightText,
    surfaceVariant = LightSecondary,
    onSurfaceVariant = LightPrimary,

    // Errores
    error = Color(0xFFBA1A1A),
    onError = Color.White,
    errorContainer = Color(0xFFFFDAD6),
    onErrorContainer = Color(0xFF410002),

    // Éxito/éxito (opcional)
    tertiary = LightAccent,
    onTertiary = Color.White,
    tertiaryContainer = LightSecondary,
    onTertiaryContainer = LightPrimary,

    // Estados
    outline = LightPrimary.copy(alpha = 0.5f),
    outlineVariant = LightSecondary,

    // Fondo inverso (para toolbars, etc)
    inverseSurface = LightText,
    inverseOnSurface = LightBackground,
    inversePrimary = LightPrimary.copy(alpha = 0.2f)
)

private val DarkColorScheme = darkColorScheme(
    // Elementos principales
    primary = DarkPrimary,
    onPrimary = Color.White,
    primaryContainer = DarkSecondary,
    onPrimaryContainer = DarkSecondary,

    // Elementos secundarios
    secondary = DarkSecondary,
    onSecondary = DarkText,
    secondaryContainer = DarkSecondary.copy(alpha = 0.3f),
    onSecondaryContainer = DarkText,

    // Fondo y superficie
    background = DarkBackground,
    onBackground = DarkText,
    surface = DarkBackground,
    onSurface = DarkText,
    surfaceVariant = DarkSecondary,
    onSurfaceVariant = DarkText,

    // Errores
    error = Color(0xFFFFB4AB),
    onError = Color(0xFF690005),
    errorContainer = Color(0xFF93000A),
    onErrorContainer = Color(0xFFFFDAD6),

    // Éxito/éxito (opcional)
    tertiary = DarkAccent,
    onTertiary = Color.White,
    tertiaryContainer = DarkSecondary,
    onTertiaryContainer = DarkText,

    // Estados
    outline = DarkText.copy(alpha = 0.5f),
    outlineVariant = DarkSecondary,

    // Fondo inverso (para toolbars, etc)
    inverseSurface = DarkText,
    inverseOnSurface = DarkBackground,
    inversePrimary = DarkPrimary.copy(alpha = 0.2f)
)

@Composable
fun FirstmovileappTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    dynamicColor: Boolean = true,
    content: @Composable () -> Unit
) {
    val colorScheme = when {
        dynamicColor && Build.VERSION.SDK_INT >= Build.VERSION_CODES.S -> {
            val context = LocalContext.current
            if (darkTheme) dynamicDarkColorScheme(context) else dynamicLightColorScheme(context)
        }

        darkTheme -> DarkColorScheme
        else -> LightColorScheme
    }

    MaterialTheme(
        colorScheme = colorScheme,
        typography = Typography,
        content = content
    )
}