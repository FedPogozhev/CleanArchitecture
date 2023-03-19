package com.example.callforinternet.presentation

import android.content.Context
import android.widget.ViewSwitcher.ViewFactory
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.callforinternet.data.repository.UserRepositoryImpl
import com.example.callforinternet.data.storage.SharedUserStorage
import com.example.callforinternet.domain.usecase.GetUserUseCase
import com.example.callforinternet.domain.usecase.SaveUserUseCase

class MainActivityViewModelFactory(context: Context) : ViewModelProvider.Factory {

    private val userRepositoryImpl by lazy {
        UserRepositoryImpl(
            sharedStorage = SharedUserStorage(
                context = context
            )
        )
    }
    private val getUserUseCase by lazy { GetUserUseCase(userRepositoryImpl) }
    private val setUserUseCase by lazy { SaveUserUseCase(userRepositoryImpl) }


    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return MainActivityViewModel(
            getUserUseCase = getUserUseCase,
            setUserUseCase = setUserUseCase
        ) as T
    }
}