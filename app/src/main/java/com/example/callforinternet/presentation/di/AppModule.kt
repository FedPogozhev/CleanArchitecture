package com.example.callforinternet.presentation.di

import android.content.Context
import com.example.callforinternet.domain.usecase.GetUserUseCase
import com.example.callforinternet.domain.usecase.SaveUserUseCase
import com.example.callforinternet.presentation.MainActivityViewModelFactory
import dagger.Module
import dagger.Provides

@Module
class AppModule(val context: Context) {

    @Provides
    fun provideContext(): Context{
        return context
    }

    @Provides
    fun provideMainViewModelFactory(
        getUserUseCase: GetUserUseCase,
        saveUserUseCase: SaveUserUseCase

    ): MainActivityViewModelFactory{
        return MainActivityViewModelFactory(
            getUserUseCase = getUserUseCase,
            saveUserUseCase = saveUserUseCase
        )
    }
}