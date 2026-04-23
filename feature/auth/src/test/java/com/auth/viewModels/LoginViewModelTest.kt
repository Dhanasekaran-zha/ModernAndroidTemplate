package com.auth.viewModels

import app.cash.turbine.test
import com.auth.ui.login.LoginUiState
import com.domain.model.AuthResult
import com.domain.usecase.LoginUseCase
import com.utils.network.Resource
import io.mockk.coEvery
import io.mockk.mockk
import junit.framework.TestCase.assertEquals
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.test.*
import org.junit.After
import org.junit.Before
import org.junit.Test

@OptIn(ExperimentalCoroutinesApi::class)
class LoginViewModelTest {

    private val loginUseCase = mockk<LoginUseCase>()
    private lateinit var viewModel: LoginViewModel

    private val testDispatcher = StandardTestDispatcher()

    @Before
    fun setup() {
        Dispatchers.setMain(testDispatcher)
        viewModel = LoginViewModel(loginUseCase)
    }

    @After
    fun tearDown() {
        Dispatchers.resetMain()
    }

    @Test
    fun `login triggers loading then success state`() = runTest {
        // Arrange
        val mockResult = AuthResult("token123", "test@test.com")

        coEvery { loginUseCase(any(), any()) } returns flow {
            emit(Resource.Loading)
            emit(Resource.Success(mockResult))
        }

        viewModel.uiState.test {
            // Initial state
            assertEquals(LoginUiState.Idle, awaitItem())

            // Act
            viewModel.login("test@test.com", "password")

            // Let coroutines run
            advanceUntilIdle()

            // Assert
            assertEquals(LoginUiState.Loading, awaitItem())

            val success = awaitItem() as LoginUiState.Success
            assert(success.message.contains("test@test.com"))
        }
    }
}