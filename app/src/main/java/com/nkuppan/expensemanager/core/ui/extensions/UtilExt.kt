package com.nkuppan.expensemanager.core.ui.extensions

import androidx.compose.ui.graphics.Color
import androidx.core.graphics.toColorInt


fun String.toColor(): Color {
    return Color(this.toColorInt())
}