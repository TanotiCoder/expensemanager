package com.nkuppan.expensemanager.domain.usecase.settings.account

import com.nkuppan.expensemanager.domain.model.Account
import com.nkuppan.expensemanager.domain.model.Resource
import com.nkuppan.expensemanager.domain.usecase.account.FindAccountByIdUseCase
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class GetSelectedAccountUseCase @Inject constructor(
    private val getFilteredAccountsUseCase: GetFilteredAccountsUseCase,
    private val findAccountByIdUseCase: FindAccountByIdUseCase
) {

    operator fun invoke(): Flow<List<Account>?> {
        return getFilteredAccountsUseCase.invoke().map { accountIds ->
            return@map buildList<Account> {
                if (accountIds?.isNotEmpty() == true) {
                    repeat(accountIds.size) {
                        val accountId = accountIds[it]
                        when (val response = findAccountByIdUseCase.invoke(accountId)) {
                            is Resource.Error -> Unit
                            is Resource.Success -> {
                                add(response.data)
                            }
                        }
                    }
                }
            }
        }
    }
}