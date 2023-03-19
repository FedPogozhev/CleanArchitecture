package com.example.callforinternet.presentation.di

import com.example.callforinternet.domain.repository.UserRepository
import com.example.callforinternet.domain.usecase.GetUserUseCase
import com.example.callforinternet.domain.usecase.SaveUserUseCase
import dagger.Module
import dagger.Provides

@Module
class DomainModule {

    @Provides
    fun provideGetUserUseCase(repository: UserRepository): GetUserUseCase{
        return GetUserUseCase(repository = repository)
    }

    @Provides
    fun provideSetUserUseCase(userRepository: UserRepository): SaveUserUseCase{
        return SaveUserUseCase(userRepository = userRepository)
    }

}