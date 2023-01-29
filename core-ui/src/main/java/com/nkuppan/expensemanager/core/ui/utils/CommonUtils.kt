package com.nkuppan.expensemanager.core.ui.utils

import com.nkuppan.expensemanager.core.ui.R

fun getCurrency(
    currencySymbol: Int,
    amount: Double
) = UiText.StringResource(
    R.string.amount_string,
    UiText.StringResource(currencySymbol),
    amount
)