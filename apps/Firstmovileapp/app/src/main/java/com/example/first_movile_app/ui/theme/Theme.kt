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
    secondaryContainer = LightTertiary,
    onSecondaryContainer = LightText,

    // Fondo y superficie - DIFERENTES
    background = LightBackground,
    onBackground = LightText,
    surface = Color.White,                   // Cards/TopBars más blancos
    onSurface = LightText,
    surfaceVariant = LightSecondary,         // Variantes ligeramente coloreadas
    onSurfaceVariant = LightText.copy(alpha = 0.7f),

    // Errores
    error = Color(0xFFBA1A1A),
    onError = Color.White,
    errorContainer = Color(0xFFFFDAD6),
    onErrorContainer = Color(0xFF410002),

    // Éxito
    tertiary = LightAccent,
    onTertiary = Color.White,
    tertiaryContainer = LightTertiary,
    onTertiaryContainer = LightText,

    // Estados
    outline = LightSecondary,
    outlineVariant = LightTertiary,

    // Fondo inverso
    inverseSurface = LightText,
    inverseOnSurface = LightBackground,
    inversePrimary = LightPrimary.copy(alpha = 0.2f)
)

private val DarkColorScheme = darkColorScheme(
    // Elementos principales
    primary = DarkPrimary,
    onPrimary = Color.White,
    primaryContainer = DarkSecondary,
    onPrimaryContainer = Color.White,

    // Elementos secundarios
    secondary = DarkSecondary,
    onSecondary = Color.White,
    secondaryContainer = DarkTertiary,
    onSecondaryContainer = Color.White,

    // Fondo y superficie - ¡JERARQUÍA CLARA!
    background = DarkBackground,           // #010104 - El más oscuro
    onBackground = DarkText,
    surface = DarkSurface,                 // #020024 - Un poco más claro
    onSurface = DarkText,
    surfaceVariant = DarkSurfaceVariant,   // #0A0A3A - Para variantes
    onSurfaceVariant = DarkText.copy(alpha = 0.8f),

    // Errores
    error = Color(0xFFFFB4AB),
    onError = Color(0xFF690005),
    errorContainer = Color(0xFF93000A),
    onErrorContainer = Color(0xFFFFDAD6),

    // Éxito
    tertiary = DarkAccent,
    onTertiary = Color.White,
    tertiaryContainer = DarkTertiary,
    onTertiaryContainer = DarkText,

    // Estados
    outline = DarkTertiary,                // #1A174A
    outlineVariant = DarkTertiary.copy(alpha = 0.5f),

    // Fondo inverso
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