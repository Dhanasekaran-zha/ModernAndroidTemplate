package com.domain.di

import com.domain.repository.AuthRepository
import com.domain.repository.EmployeeRepository
import com.domain.usecase.GetEmployeesUseCase
import com.domain.usecase.LoginUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object UseCaseModule {

    @Provides
    @Singleton
    fun provideLoginUseCase(repository: AuthRepository): LoginUseCase {
        return LoginUseCase(repository)
    }

    @Provides
    @Singleton
    fun provideGetEmployeesUseCase(repository: EmployeeRepository): GetEmployeesUseCase {
        return GetEmployeesUseCase(repository)
    }

    // As you add more UseCases (e.g., GetClientsUseCase), provide them here.
}