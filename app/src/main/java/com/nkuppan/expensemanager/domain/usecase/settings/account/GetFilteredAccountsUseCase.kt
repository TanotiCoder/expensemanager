package com.nkuppan.expensemanager.domain.usecase.settings.account

import com.nkuppan.expensemanager.domain.repository.SettingsRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetFilteredAccountsUseCase @Inject constructor(private val repository: SettingsRepository) {
    operator fun invoke(): Flow<List<String>?> {
        return repository.getAccounts()
    }
}