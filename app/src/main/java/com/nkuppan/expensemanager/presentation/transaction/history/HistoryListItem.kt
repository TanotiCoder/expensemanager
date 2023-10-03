package com.nkuppan.expensemanager.presentation.transaction.history

import com.nkuppan.expensemanager.common.ui.utils.UiText
import com.nkuppan.expensemanager.domain.model.CategoryType

class HistoryListItem(
    val text: UiText? = null,
    val totalAmount: UiText = UiText.DynamicString(""),
    var transaction: List<TransactionUIModel> = emptyList(),
    var expanded: Boolean = false,
)

data class TransactionUIModel(
    val id: String,
    val amount: UiText = UiText.DynamicString(""),
    val notes: UiText?,
    val categoryName: String,
    val categoryType: CategoryType,
    val categoryBackgroundColor: String,
    val categoryIcon: String,
    val accountName: String,
    val accountIcon: String,
    val accountColor: String,
    val date: String,
)