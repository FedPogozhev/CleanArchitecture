package com.example.callforinternet.presentation.di

import android.content.Context
import com.example.callforinternet.data.repository.UserRepositoryImpl
import com.example.callforinternet.data.storage.SharedStorage
import com.example.callforinternet.data.storage.SharedUserStorage
import com.example.callforinternet.domain.repository.UserRepository
import dagger.Module
import dagger.Provides

@Module
class DataModule {

    @Provides
    fun provideSharedStorage(context: Context): SharedStorage {
        return SharedUserStorage(context = context)
    }

    @Provides
    fun provideUserRepository(storage: SharedStorage): UserRepository{
        return UserRepositoryImpl(sharedStorage = storage)
    }

}