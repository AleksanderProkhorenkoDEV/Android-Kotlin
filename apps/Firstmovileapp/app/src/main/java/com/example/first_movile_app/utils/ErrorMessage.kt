package com.example.first_movile_app.utils

import androidx.compose.runtime.Composable
import androidx.compose.ui.res.stringResource
import com.example.first_movile_app.R
import com.example.first_movile_app.utils.FormError.EMPTY_FIELD

enum class FormError {
    EMPTY_FIELD,
    TOO_LONG
}

@Composable
fun getMessage(error: FormError):String{
    return when(error){
        FormError.EMPTY_FIELD   -> stringResource(R.string.empty_field)
        FormError.TOO_LONG      -> stringResource(R.string.too_long)
    }
}