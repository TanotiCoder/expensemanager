package com.naveenapps.expensemanager.domain.usecase.settings.filter

import com.naveenapps.expensemanager.core.domain.usecase.settings.daterange.GetDateRangeByTypeUseCase
import com.naveenapps.expensemanager.core.domain.usecase.settings.daterange.GetDateRangeUseCase
import kotlinx.coroutines.test.runTest
import org.junit.Before
import org.junit.Test
import org.mockito.kotlin.mock

class GetFilterRangeUseCaseTest {

    private lateinit var getGetFilterRangeUseCase: GetDateRangeUseCase

    @Before
    fun init() {
        val dateRangeFilterRepository =
            mock<com.naveenapps.expensemanager.core.data.repository.DateRangeFilterRepository>()
        getGetFilterRangeUseCase = GetDateRangeUseCase(
            GetDateRangeByTypeUseCase(dateRangeFilterRepository),
            dateRangeFilterRepository
        )
    }

    @Test
    fun whenUserRequestTodayDateTimeRange() = runTest {
        val result = getGetFilterRangeUseCase.invoke()
        print(result)
    }
}