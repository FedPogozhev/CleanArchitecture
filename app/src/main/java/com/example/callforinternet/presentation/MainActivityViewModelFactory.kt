package com.example.callforinternet.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.callforinternet.domain.usecase.GetUserUseCase
import com.example.callforinternet.domain.usecase.SaveUserUseCase

class MainActivityViewModelFactory(
    private val getUserUseCase: GetUserUseCase,
    private val saveUserUseCase: SaveUserUseCase
) : ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return MainActivityViewModel(
            getUserUseCase = getUserUseCase,
            setUserUseCase = saveUserUseCase
        ) as T
    }
}